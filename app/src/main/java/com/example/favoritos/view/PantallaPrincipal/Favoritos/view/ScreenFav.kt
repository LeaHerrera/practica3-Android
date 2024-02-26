package com.example.favoritos.view.PantallaPrincipal.Favoritos.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.favoritos.view.PantallaPrincipal.Scaffold.controlers.MyScaffoldFavoritos
import com.example.favoritos.viewmodel.APIViewModel

@Composable
fun ScreenFavory(navigation: NavHostController, myViewModel: APIViewModel) {

    MyScaffoldFavoritos(nav = navigation, myViewModel = myViewModel)
}
@Composable
fun Favoritos(nav: NavHostController, myViewModel: APIViewModel) {

}