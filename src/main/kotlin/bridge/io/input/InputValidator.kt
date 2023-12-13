package bridge.io.input

import bridge.constants.Constants.MOVING_UP
import bridge.constants.Constants.MOVING_DOWN
import bridge.constants.Constants.GAME_COMMAND_RETRY
import bridge.constants.Constants.GAME_COMMAND_QUIT

class InputValidator {

    fun validateBridgeSize(bridgeSize: String) {
        bridgeSize.validateInt()
        bridgeSize.toInt().validateBridgeRange()
    }

    private fun String.validateInt() =
        require(toIntOrNull() != null) { "숫자만 입력해 주세요." }

    private fun Int.validateBridgeRange() =
        require(this in BRIDGE_RANGE) {
            "$BRIDGE_MIN_SIZE 이상 $BRIDGE_MAX_SIZE 이하의 숫자만 입력해 주세요."
        }

    fun validateMoving(moving: String) =
        require(moving == MOVING_UP.value || moving == MOVING_DOWN.value) {
            "U와 D 중 하나의 문자를 입력해 주세요."
        }

    fun validateGameCommand(gameCommand: String) =
        require(gameCommand == GAME_COMMAND_RETRY.value || gameCommand == GAME_COMMAND_QUIT.value) {
            "R과 Q 중 하나의 문자를 입력해 주세요."
        }

    companion object {
        private const val BRIDGE_MIN_SIZE = 3
        private const val BRIDGE_MAX_SIZE = 20
        private val BRIDGE_RANGE = BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE
    }
}