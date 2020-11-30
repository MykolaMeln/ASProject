package com.example.asproject.screens.elements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ElementsViewModelFactory (private val text:String ) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ElementsViewModel::class.java)){

            return ElementsViewModel(text) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class!")
    }
}