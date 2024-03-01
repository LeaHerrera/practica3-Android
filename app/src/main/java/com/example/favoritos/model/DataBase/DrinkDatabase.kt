package com.example.favoritos.model.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.favoritos.model.lista.DrinkByCategorie

@Database(entities = arrayOf(DrinkByCategorie::class), version = 1)
abstract class DrinkDatabase: RoomDatabase (){
    abstract fun drinkDao(): DrinkDAO
}