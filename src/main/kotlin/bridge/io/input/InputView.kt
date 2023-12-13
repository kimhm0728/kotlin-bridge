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

    fun readMoving(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val moving = Console.readLine()

        validator.validateMoving(moving)
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
