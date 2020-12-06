package com.example.asproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Goods")
data class Goods(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "name")
    var name: String = "name" + id.toString(),
    @ColumnInfo(name = "count")
    var count: Int = 0,
    @ColumnInfo(name = "code")
    var code: String = "111111",
    @ColumnInfo(name = "date_of_create")
    var date_of_create: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "date_of_changed")
    var date_of_changed: Long = date_of_create
)