package com.example.favoritos.API

class Repository {

    val apiInterface = InterfaceAPI.create()

    suspend fun getAllCharacters() = apiInterface.getCateories()
}