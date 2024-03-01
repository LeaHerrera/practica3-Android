package com.example.favoritos.viewmodel

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.favoritos.API.Repository
import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.categorias.CategorieOfDrinks
import com.example.favoritos.model.id.Data
import com.example.favoritos.model.lista.DataCategorie
import com.example.favoritos.model.lista.DrinkByCategorie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class APIViewModel:ViewModel(){

    private val repository = Repository()


    //CATEGORIAS
    private val _characters = MutableLiveData<Categorias>()
    val characters = _characters

    //LISTA CATEGORIA
    private val _dataCat = MutableLiveData<DataCategorie>()
    val dataCat = _dataCat

    private val _drinkByCategorie = MutableLiveData<DrinkByCategorie>()
    val drinkByCategorie = _drinkByCategorie

    //ID DRINK
    private val _idDrink = MutableLiveData<Data>()
    val idDrink = _idDrink

    private var _categoria = MutableLiveData("")
    private var _id = MutableLiveData("")

    //SHOW's
    private var _mostrarCategoria = MutableLiveData(true)
    val mostrarCategoria = _mostrarCategoria

    private val _loading = MutableLiveData(true)
    val loading = _loading

    private var _mostrarIngredientes = MutableLiveData(true)
    val mostrarIngredientes = _mostrarIngredientes

    //DATABASE (FAVORITOS)
    private val _isFavorite = MutableLiveData(false)
    val isFavorite = _isFavorite
    private val _favorites = MutableLiveData<MutableList<DrinkByCategorie>>()
    val favorites = _favorites

    private val _iconFavory = MutableLiveData(Icons.Default.FavoriteBorder)
    val iconFavory = _iconFavory

    //METODOS

    fun llenarCorazon(){
        _iconFavory.value = Icons.Default.Favorite
    }
    fun vaciarCorazon(){
        _iconFavory.value = Icons.Default.FavoriteBorder
    }
    fun setMostrarIngredientes(){
        _mostrarIngredientes.value = false
    }

    fun setOcultarIngredientes(){
        _mostrarIngredientes.value = true
    }
    fun setCategorie(categorieOfDrinks: CategorieOfDrinks){
        _categoria.value = categorieOfDrinks.strCategory
        _mostrarCategoria.value = false
    }

    fun setCategorie(){
        _mostrarCategoria.value = false
    }

    fun setIdAndDrink(drink: DrinkByCategorie){
        _id.value = drink.idDrink
        _drinkByCategorie.value = drink
    }

    fun getCategoria(): String? {
        return _categoria.value
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
                } else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }

    fun getDrinkById(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getIdDrink(_id.value!!)
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    _idDrink.value = response.body()
                    _loading.value = false
                } else{
                    Log.e("Error :", response.message())
                }
            }
        }
    }

    fun getFavorites(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getFavorites()
            withContext(Dispatchers.Main){
                _favorites.value = response
                _loading.value = false
            }
        }
    }

    fun isFavorite(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.isFavorite(id)
            withContext(Dispatchers.Main){
                _isFavorite.value = response
            }
        }
        if (_isFavorite.value!!){
            llenarCorazon()
        } else {
            vaciarCorazon()
        }
    }

    fun saveAsFavorite(drink: DrinkByCategorie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.saveAsFavorite(drink)
        }
    }

    fun deleteFavorite(drink: DrinkByCategorie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteFavorite(drink)
        }
    }


}