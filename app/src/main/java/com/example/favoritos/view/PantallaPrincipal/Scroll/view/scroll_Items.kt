package com.example.favoritos.view.PantallaPrincipal.Scroll.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.lista.DataCategorie
import com.example.favoritos.viewmodel.APIViewModel


@Composable
fun ScrollItems(nav: NavHostController, api: APIViewModel, show: Boolean){
    val categorias: Categorias by api.characters.observeAsState(Categorias(emptyList()))
    val drinkCat: DataCategorie by api.dataCat.observeAsState(DataCategorie(emptyList()))

    if (show){
        LazyColumn() {
            items(categorias.drinks) {
                CharacterItem(CategorieOfDrinks = it, apiViewModel = api)
            }
        }
    } else {
        LazyColumn() {
            items(drinkCat.drinks) {
                ItemsByCategory(drink = it , nav , api)
            }
        }
    }


}
