package com.example.favoritos.model.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DrinkEntity")
data class Drink (
    @PrimaryKey
    val id:String,
    val nom:String,
    val image:String
)