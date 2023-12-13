package bridge.service

import bridge.constants.Constants.GAME_COMMAND_RETRY
import bridge.constants.Constants.MOVING_UP
import bridge.model.BridgeGameResult
import bridge.model.MovingResult

class BridgeGame {

    private val upResult = MovingResult()
    private val downResult = MovingResult()
    private var isSuccess = true
    private var tryCount = 1

    fun getRoundResult() = upResult to downResult

    fun getGameResult() = BridgeGameResult(upResult, downResult, isSuccess, tryCount)

    private fun clear() {
        upResult.clear()
        downResult.clear()
    }

    fun move(isMoving: Boolean, moving: String) {
        val result = if (isMoving) "O" else "X"
        if (moving == MOVING_UP.value) {
            upResult.add(result)
            downResult.add(" ")
            return
        }

        downResult.add(result)
        upResult.add(" ")
    }

    fun retry(gameCommand: String) =
        (gameCommand == GAME_COMMAND_RETRY.value).also { isRetry ->
            isSuccess = isRetry
            tryCount++
            if (isRetry) clear()
        }
}
