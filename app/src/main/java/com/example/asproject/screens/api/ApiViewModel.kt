package com.example.asproject.screens.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.asproject.network.NumAPI
import com.example.asproject.network.NumProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiViewModel : ViewModel() {
    private val _IMAGE_URL = MutableLiveData<String>()
    val IMAGE_URL: LiveData<String>
        get() = _IMAGE_URL


    private val _number = MutableLiveData<String>()
    val number: LiveData<String>
        get() = _number

    init {
        _IMAGE_URL.value = "https://www.e2eqatar.com/wp-content/uploads/2018/02/pic-4.jpg"
        getRandomFact()
    }

    private fun getRandomFact(){
        NumAPI.retrofitService.getProperties().enqueue(object : Callback<NumProperty> {
            override fun onFailure(call: Call<NumProperty>, t:Throwable){
                _number.value = "Failure:" + t.message
            }

            override fun onResponse(call: Call<NumProperty>, response: Response<NumProperty>){
                _number.value = response.body()?.text
            }
        })
        _number.value = "Set the Number API Response here!"
    }

}