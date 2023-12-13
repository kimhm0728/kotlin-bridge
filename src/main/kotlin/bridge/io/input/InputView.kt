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

    fun readGameCommand(): Char {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val gameCommand = Console.readLine()

        validator.validateGameCommand(gameCommand)
        return gameCommand[0]
    }
}
