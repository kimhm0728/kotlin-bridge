package bridge.model

class Bridge(private val bridge: List<String>) {

    fun isMoving(idx: Int, moving: String) = bridge[idx] == moving
}