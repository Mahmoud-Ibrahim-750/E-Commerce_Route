package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts

import com.mis.route.e_commerce.data.models.auth.User

sealed class RegisterScreenState {
    data class NavigateToHome(val user: User, val token: String) : RegisterScreenState()
//    data class InvalidUserInput(
//        val usernameError: String?,
//        val passwordError: String?
//    ) : LoginScreenState()

}
