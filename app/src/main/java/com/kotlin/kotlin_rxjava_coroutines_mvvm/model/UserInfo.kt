package com.kotlin.kotlin_rxjava_coroutines_mvvm.model


import com.google.gson.annotations.SerializedName

data class UserInfo(
    val email: String,
    val image: String,
    val username: String
)