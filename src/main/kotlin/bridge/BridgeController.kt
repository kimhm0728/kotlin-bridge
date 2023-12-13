package bridge

import bridge.io.OutputView
import bridge.io.input.InputView
import bridge.model.Bridge
import bridge.service.BridgeGame
import bridge.service.BridgeMaker
import bridge.service.BridgeRandomNumberGenerator
import bridge.util.retryWhileNoException

class BridgeController(private val inputView: InputView, private val outputView: OutputView) {

    private val bridgeSize: Int
    private val bridge: Bridge

    init {
        outputView.printStart()
        bridgeSize = composeBridgeSize()
        bridge = composeBridge(bridgeSize)
    }

    private fun composeBridgeSize() = retryWhileNoException {
        inputView.readBridgeSize()
    }

    private fun composeBridge(bridgeSize: Int): Bridge {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        return bridgeMaker.makeBridge(bridgeSize).toBridge()
    }

    private fun List<String>.toBridge() = Bridge(this)

    fun run() {
        val bridgeGame = BridgeGame()

        while (!progressGame(bridgeGame)) {
            val gameCommand = retryWhileNoException { inputView.readGameCommand() }
            if (bridgeGame.retry(gameCommand)) continue
            break
        }

        val bridgeGameResult = bridgeGame.getGameResult()
        outputView.printResult(bridgeGameResult)
    }

    private fun progressGame(bridgeGame: BridgeGame): Boolean {
        for (idx in 0 until bridgeSize) {
            val moving = retryWhileNoException { inputView.readMoving() }

            val isMoving = bridge.isMoving(idx, moving)
            bridgeGame.move(isMoving, moving)
            outputView.printMap(bridgeGame.getRoundResult())

            if (!isMoving) return false
        }
        return true
    }
}