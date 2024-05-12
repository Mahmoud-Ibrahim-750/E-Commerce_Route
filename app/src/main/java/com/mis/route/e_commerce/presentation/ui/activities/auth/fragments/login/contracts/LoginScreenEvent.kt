package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.login.contracts

sealed class LoginScreenEvent {
    data class Login(val email: String, val password: String) : LoginScreenEvent()
    data object NavigateToRegister : LoginScreenEvent()
}
