package bridge.model

class MovingResult {
    private val resultStore = mutableListOf<String>()

    fun clear() = resultStore.clear()

    fun add(result: String) = resultStore.add(result)

    override fun toString() =
        "[ ${resultStore.joinToString(" | ")} ]"
}