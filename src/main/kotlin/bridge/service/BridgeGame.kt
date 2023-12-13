package bridge.service

import bridge.constants.Constants.GAME_COMMAND_RETRY
import bridge.constants.Constants.MOVING_UP
import bridge.io.input.InputView
import bridge.model.MovingResult
import bridge.util.retryWhileNoException

class BridgeGame(private val upResult: MovingResult, private val downResult: MovingResult) {

    private val inputView = InputView()

    private fun moveResult(bridgeShape: String, moving: String): Boolean {
        if (moving == MOVING_UP.value) {
            downResult.add(" ")
            if (bridgeShape != moving) {
                upResult.add("X")
                return false
            }
            upResult.add("O")
            return true
        }

        upResult.add(" ")
        if (bridgeShape != moving) {
            downResult.add("X")
            return false
        }
        downResult.add("O")
        return true
    }

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
