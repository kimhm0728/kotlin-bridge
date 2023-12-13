package bridge.io.input

import bridge.constants.Constants.MOVING_UP
import bridge.constants.Constants.MOVING_DOWN

class InputValidator {

    fun validateBridgeSize(bridgeSize: String) {
        bridgeSize.validateInt()
        bridgeSize.toInt().validateBridgeRange()
    }

    private fun String.validateInt() =
        require(toIntOrNull() != null) { "숫자만 입력해 주세요." }

    private fun Int.validateBridgeRange() =
        require(this in BRIDGE_RANGE) { "3 이상 20 이하의 숫자만 입력해 주세요." }

    fun validateMoving(moving: String) {
        moving.validateLength()
        moving[0].validateMoving()
    }

    private fun String.validateLength() =
        require(length == 1) { "하나의 문자만 입력해 주세요." }

    private fun Char.validateMoving() =
        require(this == MOVING_UP.value || this == MOVING_DOWN.value) { "하나의 문자만 입력해 주세요." }

    companion object {
        private val BRIDGE_RANGE = 3..20
    }
}