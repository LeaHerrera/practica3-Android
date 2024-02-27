package com.example.favoritos.model.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DrinkDAO {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAllDrinks(): MutableList<Drink>

    @Query("SELECT * FROM DrinkEntity WHERE id = :drinkId")
    suspend fun getDrinkById(drinkId: String):MutableList<Drink>

    @Insert
    suspend fun addDink(drink: Drink)

    @Delete
    suspend fun deleteDrink(drink: Drink)
}