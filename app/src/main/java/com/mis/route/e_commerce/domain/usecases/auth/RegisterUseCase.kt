package com.mis.route.e_commerce.domain.usecases.auth

import com.mis.route.e_commerce.data.models.auth.register.RegisterResponse
import com.mis.route.e_commerce.domain.repositories.auth.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
        rePassword: String,
        phone: String
    ): RegisterResponse {
        return authRepository.register(name, email, password, rePassword, phone)
    }
}