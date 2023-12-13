package bridge

import bridge.io.OutputView
import bridge.io.input.InputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeController = BridgeController(inputView, outputView)

    bridgeController.run()
}
