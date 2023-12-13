package bridge.service

import bridge.constants.Constants.GAME_COMMAND_RETRY
import bridge.io.OutputView
import bridge.io.input.InputView
import bridge.util.retryWhileNoException

class BridgeGame {

    private val inputView = InputView()

    fun move() = retryWhileNoException {
        inputView.readMoving()
    }

    fun retry(): Boolean {
        val gameCommand = retryWhileNoException {
            inputView.readGameCommand()
        }

        return gameCommand == GAME_COMMAND_RETRY.value
    }
}
