package bridge.io

import bridge.model.MovingResult

class OutputView {

    fun printStart() {
        println("다리 건너기 게임을 시작합니다.")
        lineBreak()
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upResult: MovingResult, downResult: MovingResult) {
        println(upResult)
        println(downResult)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    private fun lineBreak() = println()
}
