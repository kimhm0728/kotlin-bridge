package bridge.service

import bridge.constants.Constants.GAME_COMMAND_RETRY
import bridge.constants.Constants.MOVING_UP
import bridge.model.BridgeGameResult
import bridge.model.MovingResult

class BridgeGame {

    private val up = MovingResult()
    private val down = MovingResult()
    private var isSuccess = true
    private var tryCount = 1

    fun getResult() = BridgeGameResult(up, down, isSuccess, tryCount)

    private fun clear() {
        up.clear()
        down.clear()
    }

    fun move(isMoving: Boolean, moving: String) {
        val result = if (isMoving) "O" else "X"
        if (isMovingUp(moving)) {
            up.add(result)
            down.add(" ")
            return
        }

        down.add(result)
        up.add(" ")
    }

    private fun isMovingUp(moving: String) = moving == MOVING_UP.value

    fun retry(gameCommand: String) = isRetry(gameCommand).also { isRetry ->
        isSuccess = isRetry
        tryCount++
        if (isRetry) clear()
    }

    private fun isRetry(gameCommand: String) =
        gameCommand == GAME_COMMAND_RETRY.value
}
