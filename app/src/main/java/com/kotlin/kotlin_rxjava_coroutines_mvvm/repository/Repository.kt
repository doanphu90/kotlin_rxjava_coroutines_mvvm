package com.kotlin.kotlin_rxjava_coroutines_mvvm.repository

import androidx.lifecycle.LiveData
import com.kotlin.kotlin_rxjava_coroutines_mvvm.model.UserInfo
import com.kotlin.kotlin_rxjava_coroutines_mvvm.retrofit.RetrofitBiulder
import kotlinx.coroutines.*

object Repository {
    var job: CompletableJob? = null
    fun getUserId(userId: String): LiveData<UserInfo> {
        job = Job()
        return object : LiveData<UserInfo>() {
            override fun onActive() {
                super.onActive()
                job?.let { completableJob ->
                    CoroutineScope(Dispatchers.IO + completableJob).launch {
                        val user = RetrofitBiulder.apiInterface.getUserId(userId)
                        withContext(Dispatchers.Main) {
                            //withContext change thread running here IO to Main
                            value = user
                            completableJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        job?.cancel()
    }
}