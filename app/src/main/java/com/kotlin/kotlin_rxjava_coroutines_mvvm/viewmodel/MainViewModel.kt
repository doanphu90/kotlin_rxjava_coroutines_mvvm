package com.kotlin.kotlin_rxjava_coroutines_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kotlin.kotlin_rxjava_coroutines_mvvm.model.UserInfo
import com.kotlin.kotlin_rxjava_coroutines_mvvm.repository.Repository

class MainViewModel:ViewModel() {
    private val _userId:MutableLiveData<String> = MutableLiveData()
    val user:LiveData<UserInfo> = Transformations.switchMap(_userId){
        userId ->  Repository.getUserId(userId)
    }

    fun setUserID(userID:String){
        val update = userID
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJob(){
        Repository.cancelJob()
    }
}