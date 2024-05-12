package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts

import com.mis.route.e_commerce.data.models.auth.User

sealed class LoginScreenState {
    data class NavigateToHome(val user: User, val token: String) : LoginScreenState()
    data object NavigateToRegister : LoginScreenState()
//    data class InvalidUserInput(
//        val usernameError: String?,
//        val passwordError: String?
//    ) : LoginScreenState()

}
