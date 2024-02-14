package com.example.favoritos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.favoritos.model.categorias.Drink


class ScrollViewModel:ViewModel (){

    private var _categoria by mutableStateOf("")
    val categoria = _categoria

    private var _mostrarCategoria by mutableStateOf(false)
    val mostrarCategoria = _mostrarCategoria

    fun setCategorie(drink: Drink){
        _categoria = drink.strCategory
        _mostrarCategoria = true
    }

    fun setOcultar(){
        _mostrarCategoria = false
    }

}