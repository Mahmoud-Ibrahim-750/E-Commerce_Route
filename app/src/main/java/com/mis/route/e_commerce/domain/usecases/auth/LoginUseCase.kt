package com.mis.route.e_commerce.domain.usecases.auth

import com.mis.route.e_commerce.data.models.auth.login.LoginResponse
import com.mis.route.e_commerce.domain.repositories.auth.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): LoginResponse {
        return authRepository.login(email, password)
    }
}