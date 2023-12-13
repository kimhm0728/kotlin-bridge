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

    private fun makeBridgeShape(): String {
        bridgeNumberGenerator.generate().run {
            if (this == 0) return MOVING_DOWN.value
        }
        return MOVING_UP.value
    }
}
