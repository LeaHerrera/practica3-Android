package com.example.favoritos.API

import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.id.Data
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceAPI {

    @GET("filter.php?f={letra}")
    suspend fun getFirsChar( @Path("letra") char:String ): Response<Data>
  //  suspend fun getCategorie(): Response<Data>

    @GET("filter.php?i={id}")
    suspend fun getId( @Path("id") charId:String ): Response<Data>
    @GET("filter.php?c={categoria}")
    suspend fun getDrinkCategorie( @Path("categoria") categorie:String ): Response<Data>

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