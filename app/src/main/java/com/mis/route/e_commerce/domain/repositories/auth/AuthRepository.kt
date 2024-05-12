package com.mis.route.e_commerce.domain.repositories.auth

import com.mis.route.e_commerce.data.models.auth.login.LoginResponse

interface AuthRepository {

    suspend fun login(email: String, password: String): LoginResponse
}