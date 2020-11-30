package com.example.asproject.screens.elements

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ElementsViewModel(text:String) : ViewModel(){

    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    private val _event = MutableLiveData<Boolean>()
    val event: LiveData<Boolean>
        get() = _event

    init
    {
        _event.value = false
        _text.value = text
        Timber.i("elementsviewmodel Created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("elementsviewmodel Destroyed!")
    }

    fun ActiveEvent(){
        _event.value = true
        _text.value = "Event true text"
    }

    fun NoActiveEvent(){
        _event.value = false

    }

}