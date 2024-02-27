package com.example.favoritos.model.DataBase

import android.app.Application
import androidx.room.Room

class DrinkApplication: Application () {
    companion object{
        lateinit var database: DrinkDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,
            DrinkDatabase::class.java,
            "DrinkDatabase"
        ).build()
    }
}