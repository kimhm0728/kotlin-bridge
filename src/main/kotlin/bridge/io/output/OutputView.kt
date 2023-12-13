package bridge.io.output

import bridge.model.BridgeGameResult

class OutputView {

    fun printStart() {
        println("다리 건너기 게임을 시작합니다.")
        lineBreak()
    }

    fun printMap(bridgeGameResult: BridgeGameResult) {
        println(bridgeGameResult.up)
        println(bridgeGameResult.down)
        lineBreak()
    }

    fun printResult(bridgeGameResult: BridgeGameResult) {
        println("최종 게임 결과")
        printMap(bridgeGameResult)
        printSuccess(bridgeGameResult)
        println("총 시도한 횟수: ${bridgeGameResult.tryCount}")
    }

    private fun printSuccess(bridgeGameResult: BridgeGameResult) {
        val isSuccess = if (bridgeGameResult.isSuccess) "성공" else "실패"
        println("게임 성공 여부: $isSuccess")
    }

    private fun lineBreak() = println()
}
