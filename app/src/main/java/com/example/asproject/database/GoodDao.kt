package com.example.asproject.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GoodDao{
    @Insert
    fun insert(goods: Goods)
    @Update
    fun update(goods: Goods)
    @Query("SELECT * FROM Goods WHERE id= :key")
    fun get(key: Long): Goods
    @Query("DELETE FROM Goods")
    fun delete()
    @Query("SELECT * FROM Goods ORDER BY date_of_changed DESC")
    fun get_all_goods(): LiveData<List<Goods>>
    @Query("SELECT * FROM Goods ORDER BY date_of_changed DESC Limit 1")
    fun get_last_goods(): Goods?
}