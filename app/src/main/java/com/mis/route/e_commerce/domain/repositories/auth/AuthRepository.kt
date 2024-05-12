package com.mis.route.e_commerce.domain.repositories.auth

import com.mis.route.e_commerce.data.models.auth.login.LoginResponse
import com.mis.route.e_commerce.data.models.auth.register.RegisterResponse

interface AuthRepository {

    suspend fun login(email: String, password: String): LoginResponse

    suspend fun register(
        name: String,
        email: String,
        password: String,
        rePassword: String,
        phone: String
    ): RegisterResponse
}