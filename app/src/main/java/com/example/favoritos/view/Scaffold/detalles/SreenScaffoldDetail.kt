package com.example.favoritos.view.Scaffold.detalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.favoritos.model.BotomNavigation.BottomNavigationScreens
import com.example.favoritos.view.Detail.view.Detail
import com.example.favoritos.view.Scaffold.favoritos.MyTopAppBarF
import com.example.favoritos.view.Scaffold.general.MyBottomBar
import com.example.favoritos.viewmodel.APIViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyScaffoldDetail(nav:NavHostController, myViewModel:APIViewModel){

    val bottomNavigationItem = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favorite
    )
    val showIngredientes: Boolean by myViewModel.mostrarIngredientes.observeAsState(true)

    val titulo = "information"
    Scaffold(
        topBar = { MyTopAppBarD(titulo , myViewModel, showIngredientes) },
        bottomBar = { MyBottomBar( nav , bottomNavigationItem)  }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ){
            if (showIngredientes){
                Detail(myViewModel = myViewModel )
            } else {

            }
        }
    }

}
