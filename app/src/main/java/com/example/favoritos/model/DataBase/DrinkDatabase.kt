package com.example.favoritos.model.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Drink::class), version = 1)
abstract class DrinkDatabase: RoomDatabase (){
    abstract fun drinkDao(): DrinkDAO
}