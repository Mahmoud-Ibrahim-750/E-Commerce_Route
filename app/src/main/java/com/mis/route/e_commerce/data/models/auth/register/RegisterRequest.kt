package com.mis.route.e_commerce.data.models.auth.register


data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val rePassword: String,
    val phone: String,
)