package com.example.favoritos.API

import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.id.Data
import com.example.favoritos.model.lista.DataCategorie
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceAPI {

    @GET("lookup.php")
    suspend fun getId( @Query("i") id:String ): Response<Data>
    @GET("filter.php")
    suspend fun getDrinkCategorie( @Query("c") categorie:String ): Response<DataCategorie>

    @GET("list.php?c=list")
    suspend fun getCateories(): Response<Categorias>
    
    companion object {
        val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
        fun create(): InterfaceAPI {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(InterfaceAPI::class.java)
        }
    }

}