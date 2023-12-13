package bridge.util

import bridge.constants.Constants.ERROR_MESSAGE

fun <T> retryWhileNoException(action: () -> T): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println("${ERROR_MESSAGE.value} ${e.localizedMessage}")
        }
    }
}