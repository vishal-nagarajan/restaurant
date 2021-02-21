package com.example.restaurant.Db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DishDao {
    @Insert
    suspend fun addDish(dish:Dish)
    @Query("SELECT * from dish ORDER BY id DESC")
    suspend fun getAllDishes():List<Dish>
    @Insert
    suspend fun addCategory(category: Category)

    @Query("SELECT * from category ORDER BY id DESC")
    suspend fun getAllCategory():List<Category>

    @Query("SELECT * FROM dish where Category=:category")
    suspend fun getSpecificDish(category:String):List<Dish>

    @Query("SELECT CountOrder FROM dish where Name=:name AND Category=:category")
    suspend fun getCount(name:String,category:String):Int

    @Query("UPDATE dish SET CountOrder=:count where Name=:name AND Category=:category")
    suspend fun updateCount(count:Int,name:String,category: String)

    @Query("SELECT * FROM dish where CountOrder>0")
    suspend fun getDishesAddedToCart():List<Dish>

    @Query("UPDATE dish SET CountOrder=:value")
    suspend fun placeporder(value:Int)
}