package com.mis.route.e_commerce.data.data_sources.remote.api

import com.mis.route.e_commerce.data.DataConstants
import com.mis.route.e_commerce.data.models.auth.login.LoginRequest
import com.mis.route.e_commerce.data.models.auth.login.LoginResponse
import com.mis.route.e_commerce.data.models.auth.register.RegisterRequest
import com.mis.route.e_commerce.data.models.auth.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RouteEcommerceService {

    @POST(DataConstants.LOGIN_URL)
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST(DataConstants.REGISTER_URL)
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): RegisterResponse
}