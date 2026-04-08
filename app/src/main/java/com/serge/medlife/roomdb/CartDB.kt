package com.serge.medlife.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartItems::class], version = 1)
abstract class CartDB: RoomDatabase() {

    abstract fun cartDao(): CartDao

    companion object {

        @Volatile
        private var INSTANCE: CartDB? = null

        fun getDatabase(context: Context): CartDB {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDB::class.java,
                    "cart_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}