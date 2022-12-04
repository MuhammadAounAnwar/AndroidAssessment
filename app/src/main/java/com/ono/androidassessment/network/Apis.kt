package com.ono.androidassessment.network

import com.ono.androidassessment.UserAgeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {
    @GET("?")
    suspend fun getUserAge(@Query("name") name: String): Response<UserAgeModel>
}