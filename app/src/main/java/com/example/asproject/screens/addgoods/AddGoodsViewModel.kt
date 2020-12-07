package com.example.asproject.screens.addgoods

import android.app.Application
import androidx.lifecycle.*
import com.example.asproject.database.GoodDao
import com.example.asproject.database.Goods
import com.example.asproject.database.GoodsDB
import com.example.asproject.formatGoods
import kotlinx.coroutines.*

class AddGoodsViewModel(val database: GoodDao, application: Application) : AndroidViewModel(application) {

    var name = ""
    var code = ""
    var count = ""

    private var _showShackBarEvent = MutableLiveData<Boolean>()
    val showShackBarEvent: LiveData<Boolean>
        get() = _showShackBarEvent

    init{
        initializeRecord()
    }

    private var viewModelJob = Job()

    override fun onCleared(){
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var list_goods = database.get_all_goods()

    val list_goods_string = Transformations.map(list_goods){
        it->formatGoods(it, application.resources)
    }

    fun onStartRecording() {
        viewModelScope.launch {
            var newGood = Goods(name = name, code = code, count = count.toInt())

            insert(newGood)
            goods.value = getRecordFromDB()

            name = ""
            code = ""
            count = ""
        }

    }
    private suspend fun insert(goods: Goods)
    {
        withContext(Dispatchers.IO){
            database.insert(goods)
        }
    }

    fun onClear()
    {
        uiScope.launch {
            clear()
            goods.value = null
            _showShackBarEvent.value = true
        }
    }

    suspend fun clear()
    {
        withContext(Dispatchers.IO) {
            database.delete()
        }
    }

    private val goods = MutableLiveData<Goods?>()

    val visibility = Transformations.map(goods) {
        null != it
    }

    private fun initializeRecord(){
        viewModelScope.launch {
        getRecordFromDB()
        }
    }

    fun doneShowingSnackBar() {
        _showShackBarEvent.value = false
    }

    private suspend fun getRecordFromDB() : Goods? {
        return withContext(Dispatchers.IO) {
            var R = database.get_last_goods()
            if(R?.date_of_create!= R?.date_of_changed) {
                R = null
            }
            R
        }
    }


}