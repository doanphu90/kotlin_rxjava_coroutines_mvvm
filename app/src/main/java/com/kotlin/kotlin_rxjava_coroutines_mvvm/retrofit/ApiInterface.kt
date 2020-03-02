package com.kotlin.kotlin_rxjava_coroutines_mvvm.retrofit

import com.kotlin.kotlin_rxjava_coroutines_mvvm.model.UserInfo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("placeholder/user/{userId}")
    suspend fun getUserId(@Path("userId") userId: String): UserInfo
}