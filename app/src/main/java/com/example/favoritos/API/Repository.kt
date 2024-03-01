package com.example.favoritos.API

import com.example.favoritos.model.DataBase.DrinkApplication
import com.example.favoritos.model.lista.DrinkByCategorie

class Repository {

    //API
    val apiInterface = InterfaceAPI.create()

    suspend fun getAllCategorie() = apiInterface.getCateories()
    suspend fun getIdCategorie(tipo:String) = apiInterface.getDrinkCategorie(tipo)
    suspend fun getIdDrink(charId:String) = apiInterface.getId(charId)


    //DATABASE
    val daoInterface = DrinkApplication.database.drinkDao()

    suspend fun saveAsFavorite(drink: DrinkByCategorie) = daoInterface.addDink(drink)
    suspend fun deleteFavorite(drink: DrinkByCategorie) = daoInterface.deleteDrink(drink)
    suspend fun isFavorite(id: String) = daoInterface.getDrinkById(id).isNotEmpty()
    suspend fun getFavorites() = daoInterface.getAllDrinks()
}