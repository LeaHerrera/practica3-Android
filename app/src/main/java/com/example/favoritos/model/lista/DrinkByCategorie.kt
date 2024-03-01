package com.example.favoritos.model.lista

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DrinkEntity")
data class DrinkByCategorie(
    @PrimaryKey
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
)