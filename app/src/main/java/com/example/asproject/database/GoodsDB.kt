package com.example.asproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Goods::class],version = 1,exportSchema = false)
abstract class GoodsDB: RoomDatabase(){
    abstract val goodsDB_Dao: GoodDao

    companion object {
        @Volatile
        private var INSTANCE : GoodsDB? = null

        fun getInstance(context: Context) : GoodsDB {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GoodsDB::class.java,
                        "GoodsDB_History"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return  instance
            }
        }
    }
}