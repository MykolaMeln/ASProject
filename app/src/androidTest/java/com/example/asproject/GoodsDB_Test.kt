package com.example.asproject

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.asproject.database.GoodDao
import com.example.asproject.database.Goods
import com.example.asproject.database.GoodsDB
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class GoodsDB_Test {

    private lateinit var G_Dao: GoodDao
    private lateinit var db: GoodsDB

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, GoodsDB::class.java)
            .allowMainThreadQueries()
            .build()
       G_Dao = db.goodsDB_Dao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun method() {
        val goods = Goods()
        G_Dao.insert(goods)
        val good = G_Dao.get_last_goods()
        assertEquals(good?.count, 0)
    }
}