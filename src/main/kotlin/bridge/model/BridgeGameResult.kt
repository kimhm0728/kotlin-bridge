package bridge.model

class BridgeGameResult(
    val upResult: MovingResult,
    val downResult: MovingResult,
    val isSuccess: Boolean,
    val tryCount: Int
)