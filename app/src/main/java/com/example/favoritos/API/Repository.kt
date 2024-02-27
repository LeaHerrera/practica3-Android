package com.example.favoritos.API

import com.example.favoritos.model.DataBase.Drink
import com.example.favoritos.model.DataBase.DrinkApplication

class Repository {

    //API
    val apiInterface = InterfaceAPI.create()

    suspend fun getAllCategorie() = apiInterface.getCateories()
    suspend fun getIdCategorie(tipo:String) = apiInterface.getDrinkCategorie(tipo)
    suspend fun getIdDrink(charId:String) = apiInterface.getId(charId)


    //DATABASE
    val daoInterface = DrinkApplication.database.drinkDao()

    suspend fun saveAsFavorite(drink: Drink) = daoInterface.addDink(drink)
    suspend fun deleteFavorite(drink: Drink) = daoInterface.deleteDrink(drink)
    suspend fun isFavorite(drink: Drink) = daoInterface.getDrinkById(drink.id).isNotEmpty()
    suspend fun getFavorites() = daoInterface.getAllDrinks()
}