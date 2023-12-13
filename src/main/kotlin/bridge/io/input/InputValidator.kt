package bridge.io.input

class InputValidator {

    fun validateBridgeSize(bridgeSize: String) {
        bridgeSize.validateInt()
        bridgeSize.toInt().validateBridgeRange()
    }

    private fun String.validateInt() =
        require(toIntOrNull() != null) { "숫자만 입력해 주세요." }

    private fun Int.validateBridgeRange() =
        require(this in BRIDGE_RANGE) { "3 이상 20 이하의 숫자만 입력해 주세요." }

    companion object {
        private val BRIDGE_RANGE = 3..20
    }
}