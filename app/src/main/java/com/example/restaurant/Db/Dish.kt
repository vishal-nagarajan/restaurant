package com.example.restaurant.Db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Dish(
    val Name:String,
    val Category:String,
    val Price:Long,
    val CountOrder:Int,
    val Rating:Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}
@Entity
data class Category(
        val Category:String,
        val imageDir:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int =0
}