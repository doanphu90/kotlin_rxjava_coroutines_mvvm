package com.kotlin.kotlin_rxjava_coroutines_mvvm

import com.kotlin.kotlin_rxjava_coroutines_mvvm.model.UserInfo

object ExampleSingleton {
    val userInfo:UserInfo by lazy {
        UserInfo("doanphu@gmail.com", "PhuDoan","DoanPhu")
    }
}