package com.kotlin.kotlin_rxjava_coroutines_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.kotlin_rxjava_coroutines_mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d("DEBUG", "user information: ${ExampleSingleton.userInfo}")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(this, Observer {
            Log.d("DEBUG", "user information: $it")
        })

        viewModel.setUserID("1")
    }
}
