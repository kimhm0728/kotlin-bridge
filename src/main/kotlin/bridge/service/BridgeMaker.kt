package bridge.service

import bridge.constants.Constants.MOVING_UP
import bridge.constants.Constants.MOVING_DOWN

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (cnt in 1..size) {
            val bridgeShape = makeBridgeShape()
            bridge.add(bridgeShape)
        }
        return bridge.toList()
    }

    private fun makeBridgeShape() =
        bridgeNumberGenerator.generate().let { generateValue ->
            if (generateValue == DOWN_VALUE) MOVING_DOWN.value
            else MOVING_UP.value
        }

    companion object {
        private const val DOWN_VALUE = 0
    }
}
