package com.mis.route.e_commerce.presentation.utils


const val EMAIL_REGEX = """^((?!\.)[\w\-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$"""

object InputValidator {

    // TODO: Test this then use it
    fun validateEmail(email: String): Boolean {
        val regex = Regex(EMAIL_REGEX, setOf(RegexOption.IGNORE_CASE))
        return regex.matches(email)
    }
}