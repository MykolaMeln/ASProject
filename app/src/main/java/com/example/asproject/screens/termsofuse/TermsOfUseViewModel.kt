package com.example.asproject.screens.termsofuse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class TermsOfUseViewModel(text: String) : ViewModel(){

    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    init {
        _text.value = text
        Timber.i("Text:" + text)
    }

}