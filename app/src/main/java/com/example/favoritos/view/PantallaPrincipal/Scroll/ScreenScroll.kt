package com.example.favoritos.view.PantallaPrincipal.Scroll


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.favoritos.view.PantallaPrincipal.Scaffold.controlers.MyScaffoldScroll
import com.example.favoritos.view.PantallaPrincipal.Scroll.controlers.importAPI
import com.example.favoritos.view.PantallaPrincipal.Scroll.view.Cargando
import com.example.favoritos.viewmodel.APIViewModel


@Composable
fun ScreenScroll(navigation: NavHostController, apiViewModel: APIViewModel){
//RECYCLER VIEW
    val showLoading: Boolean by apiViewModel.loading.observeAsState(true)
    val showCategorias: Boolean by apiViewModel.mostrarCategoria.observeAsState(true)

    importAPI( apiViewModel , showCategorias )

    if(showLoading){
        Cargando()
    } else {
        MyScaffoldScroll(nav = navigation, myViewModel = apiViewModel, show = showCategorias)
    }
}



