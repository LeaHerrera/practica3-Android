package com.example.favoritos.view.PantallaPrincipal.Scaffold.controlers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.favoritos.model.BotomNavigation.BottomNavigationScreens
import com.example.favoritos.view.PantallaPrincipal.Scaffold.view.MyBottomBar
import com.example.favoritos.view.PantallaPrincipal.Scaffold.view.MyTopAppBarS
import com.example.favoritos.view.PantallaPrincipal.Scroll.view.ScrollItems
import com.example.favoritos.viewmodel.APIViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyScaffoldScroll(nav:NavHostController, myViewModel:APIViewModel, show:Boolean){

    val bottomNavigationItem = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favorite
    )
    val titulo = if (show){ "Category" } else { "Drinks" }
    Scaffold(
        topBar = { MyTopAppBarS(titulo, myViewModel, show) },
        bottomBar = { MyBottomBar( nav , bottomNavigationItem)  }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ){
            ScrollItems(nav = nav, api = myViewModel, show = show)
        }
    }


}
