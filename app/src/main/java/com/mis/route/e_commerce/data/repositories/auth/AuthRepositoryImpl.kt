package com.mis.route.e_commerce.data.repositories.auth

import com.mis.route.e_commerce.data.data_sources.remote.api.ApiManager
import com.mis.route.e_commerce.data.models.auth.login.LoginRequest
import com.mis.route.e_commerce.data.models.auth.login.LoginResponse
import com.mis.route.e_commerce.data.models.auth.register.RegisterRequest
import com.mis.route.e_commerce.data.models.auth.register.RegisterResponse
import com.mis.route.e_commerce.domain.repositories.auth.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        return ApiManager.service.login(LoginRequest(email, password))
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        rePassword: String,
        phone: String
    ): RegisterResponse {
        return ApiManager.service.register(
            RegisterRequest(
                name,
                email,
                password,
                rePassword,
                phone
            )
        )
    }
}