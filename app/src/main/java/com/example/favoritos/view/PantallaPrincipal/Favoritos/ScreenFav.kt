package com.example.favoritos.view.PantallaPrincipal.Favoritos

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.favoritos.view.Scaffold.favoritos.MyScaffoldFavoritos
import com.example.favoritos.viewmodel.APIViewModel

@Composable
fun ScreenFavory(navigation: NavHostController, myViewModel: APIViewModel) {

    MyScaffoldFavoritos(nav = navigation, myViewModel = myViewModel)
}
