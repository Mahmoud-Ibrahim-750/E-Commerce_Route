package com.mis.route.e_commerce.data.repositories.auth

import com.mis.route.e_commerce.data.data_sources.remote.api.ApiManager
import com.mis.route.e_commerce.data.models.auth.login.LoginRequest
import com.mis.route.e_commerce.data.models.auth.login.LoginResponse
import com.mis.route.e_commerce.domain.repositories.auth.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String): LoginResponse {
        return ApiManager.service.login(LoginRequest(email, password))
    }
}