package com.example.asproject.screens.addgoods

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.asproject.database.GoodDao
import com.example.asproject.database.GoodsDB
import com.example.asproject.screens.elements.ElementsViewModel
import java.lang.IllegalArgumentException

class AddGoodsViewModelFactory (private val datasource: GoodDao, private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddGoodsViewModel::class.java)){

            return AddGoodsViewModel(datasource, application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class!")
    }
}