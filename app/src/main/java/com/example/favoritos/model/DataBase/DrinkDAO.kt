package com.example.favoritos.model.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.favoritos.model.lista.DrinkByCategorie

@Dao
interface DrinkDAO {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAllDrinks(): MutableList<DrinkByCategorie>

    @Query("SELECT * FROM DrinkEntity WHERE idDrink = :drinkId")
    suspend fun getDrinkById(drinkId: String):MutableList<DrinkByCategorie>

    @Insert
    suspend fun addDink(drink: DrinkByCategorie)

    @Delete
    suspend fun deleteDrink(drink: DrinkByCategorie)
}