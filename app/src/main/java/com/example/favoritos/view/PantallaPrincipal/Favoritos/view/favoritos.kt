package com.example.favoritos.view.PantallaPrincipal.Favoritos.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.favoritos.model.lista.DrinkByCategorie
import com.example.favoritos.view.PantallaPrincipal.Scroll.view.Cargando
import com.example.favoritos.view.PantallaPrincipal.Scroll.view.ItemsByCategory
import com.example.favoritos.view.Scaffold.scroleable.MyScaffoldScroll
import com.example.favoritos.viewmodel.APIViewModel

@Composable
fun Favoritos(nav: NavHostController, myViewModel: APIViewModel) {

    val showLoading: Boolean by myViewModel.loading.observeAsState(true)
    val drinksByFavory: MutableList<DrinkByCategorie> by myViewModel.favorites.observeAsState(mutableListOf(
        DrinkByCategorie("","","")
    ))
    myViewModel.getFavorites()

    if(showLoading){
        Cargando()
    } else {
        LazyColumn() {
            items(drinksByFavory) {
                ItemsByCategory(drink = it, navigation = nav, api = myViewModel )
            }
        }
    }
}