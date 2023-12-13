package bridge.model

class BridgeGameResult(
    val up: MovingResult,
    val down: MovingResult,
    val isSuccess: Boolean,
    val tryCount: Int
)