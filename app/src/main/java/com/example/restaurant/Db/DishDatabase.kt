package com.example.restaurant.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext
import java.util.concurrent.locks.Lock

@Database(
    entities = arrayOf(Dish::class,Category::class),version = 1
//    entities = [client::class],
//    version = 1
)
abstract class DishDatabase  : RoomDatabase() {
     abstract fun getDishDao():DishDao
    companion object{
        @Volatile private var instance : DishDatabase? =null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance= it
            }
        }
        private fun buildDatabase(context:Context)= Room.databaseBuilder(
            context.applicationContext,
            DishDatabase::class.java,
            "Dishdatabase").build()
    }


}