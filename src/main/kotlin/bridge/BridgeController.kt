package bridge

import bridge.io.output.OutputView
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
        bridgeSize = inputBridgeSize()
        bridge = makeBridge(bridgeSize)
    }

    private fun inputBridgeSize() = retryWhileNoException {
        inputView.readBridgeSize()
    }

    private fun makeBridge(bridgeSize: Int): Bridge {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        return bridgeMaker.makeBridge(bridgeSize).toBridge()
    }

    private fun List<String>.toBridge() = Bridge(this)

    fun run() {
        val bridgeGame = BridgeGame()
        bridgeGame.start()
        outputView.printResult(bridgeGame.getResult())
    }

    private fun BridgeGame.start() {
        while (!progressGame()) {
            val gameCommand = inputGameCommand()
            if (retry(gameCommand)) continue
            break
        }
    }

    private fun BridgeGame.progressGame(): Boolean {
        for (idx in 0 until bridgeSize) {
            val moving = inputMoving()

            val isMoving = bridge.isMoving(idx, moving)
            move(isMoving, moving)
            outputView.printMap(getResult())

            if (!isMoving) return false
        }
        return true
    }

    private fun inputGameCommand() = retryWhileNoException { inputView.readGameCommand() }

    private fun inputMoving() = retryWhileNoException { inputView.readMoving() }
}