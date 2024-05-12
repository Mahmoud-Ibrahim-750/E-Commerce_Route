package com.mis.route.e_commerce.data.models.auth.login

import com.google.gson.annotations.SerializedName
import com.mis.route.e_commerce.data.models.auth.User

data class LoginResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("token")
    val token: String? = null
)