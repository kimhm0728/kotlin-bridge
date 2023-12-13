package bridge

import bridge.io.OutputView
import bridge.io.input.InputView
import bridge.model.MovingResult
import bridge.service.BridgeGame
import bridge.service.BridgeMaker
import bridge.service.BridgeRandomNumberGenerator
import bridge.util.retryWhileNoException

class BridgeController(inputView: InputView, private val outputView: OutputView) {

    private val bridge: List<String>

    init {
        outputView.printStart()
        val bridgeSize = retryWhileNoException { inputView.readBridgeSize() }
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun run() {
        val upResult = MovingResult()
        val downResult = MovingResult()
        val bridgeGame = BridgeGame(upResult, downResult)
        val bridgeGameResult = bridgeGame.start(bridge)

        outputView.printResult(bridgeGameResult)
    }
}