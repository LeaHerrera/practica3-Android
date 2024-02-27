package com.example.favoritos.view.Detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.favoritos.view.Scaffold.detalles.MyScaffoldDetail
import com.example.favoritos.viewmodel.APIViewModel

@Composable
fun ScreenDetails(navigation: NavHostController, myViewModel: APIViewModel ){

    MyScaffoldDetail(nav = navigation, myViewModel = myViewModel)
}



