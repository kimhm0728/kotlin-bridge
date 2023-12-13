package bridge.io.input

import camp.nextstep.edu.missionutils.Console

class InputView {

    private val validator = InputValidator()

    fun readBridgeSize(): Int {
        println("다리의 길이를 입력해주세요.")
        val inputBridgeSize = Console.readLine()
        println()

        validator.validateBridgeSize(inputBridgeSize)
        return inputBridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
