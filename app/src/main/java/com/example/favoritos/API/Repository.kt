package com.example.favoritos.API

class Repository {

    val apiInterface = InterfaceAPI.create()

    suspend fun getAllCategorie() = apiInterface.getCateories()

    suspend fun getIdCategorie(tipo:String) = apiInterface.getDrinkCategorie(tipo)

    suspend fun getIdDrink(charId:String) = apiInterface.getId(charId)
}