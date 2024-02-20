package com.example.favoritos.viewmodel

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.favoritos.API.Repository
import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.categorias.Drink
import com.example.favoritos.model.id.Data
import com.example.favoritos.model.lista.DataCategorie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class APIViewModel:ViewModel(){

    private val repository = Repository()

    private val _loading = MutableLiveData(true)
    val loading = _loading

    //CATEGORIAS
    private val _characters = MutableLiveData<Categorias>()
    val characters = _characters

    //LISTA CATEGORIA
    private val _dataCat = MutableLiveData<DataCategorie>()
    val dataCat = _dataCat

    //ID DRINK
    private val _idDrink = MutableLiveData<Data>()
    val idDrink = _idDrink

    private var _categoria = MutableLiveData("")
    private var _id = MutableLiveData("")

    private var _mostrarCategoria = MutableLiveData(true)
    val mostrarCategoria = _mostrarCategoria

    fun setCategorie(drink: Drink){
        _categoria.value = drink.strCategory
        _mostrarCategoria.value = false
    }

    fun setId(id: String){
        _id.value = id
    }


    fun setOcultar(){
        _mostrarCategoria.value = true
    }

    fun setResetLoading(){
        _loading.value = true
    }

    fun getCategory(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllCategorie()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    _characters.value = response.body()
                    _loading.value = false
                }
                else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }

    fun getIdCategory(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getIdCategorie( _categoria.value!! )
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    _dataCat.value = response.body()
                    _loading.value = false
                }
                else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }

    fun getIdDrink(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getIdDrink(_id.value!!)
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    _idDrink.value = response.body()
                    _loading.value = false
                }
                else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }


}