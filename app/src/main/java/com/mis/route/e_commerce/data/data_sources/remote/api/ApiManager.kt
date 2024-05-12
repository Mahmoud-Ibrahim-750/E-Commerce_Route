package com.mis.route.e_commerce.data.data_sources.remote.api

import com.mis.route.e_commerce.data.DataConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(DataConstants.ROUTE_ECOMMERCE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: RouteEcommerceService by lazy {
        retrofit.create(RouteEcommerceService::class.java)
    }
}