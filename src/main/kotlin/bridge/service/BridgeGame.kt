package bridge.service

import bridge.io.input.InputView
import bridge.util.retryWhileNoException

class BridgeGame {

    private val inputView = InputView()

    fun move() = retryWhileNoException {
        inputView.readMoving()
    }

    fun retry() {}
}
