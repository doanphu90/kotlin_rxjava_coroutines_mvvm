package com.kotlin.kotlin_rxjava_coroutines_mvvm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBiulder {
    const val BASE_URL = "https://open-api.xyz/"

    val retrofitBuilder:Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface:ApiInterface by lazy {
        retrofitBuilder.build().create(ApiInterface::class.java)
    }
}