package com.mis.route.e_commerce.presentation.ui.activities.auth.fragments.register.contracts

sealed class RegisterScreenEvent {
    data class Register(
        val name: String,
        val email: String,
        val password: String,
        val rePassword: String,
        val phone: String
    ) : RegisterScreenEvent()
}
