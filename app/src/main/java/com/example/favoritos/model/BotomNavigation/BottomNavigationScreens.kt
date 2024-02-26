package com.example.favoritos.model.BotomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.favoritos.navigation.Routes

open class BottomNavigationScreens {

    val route:String
    val icon:ImageVector
    val label:String

    constructor( route:String , icon: ImageVector, label:String){
        this.route = route
        this.icon = icon
        this.label = label
    }

    object Home:BottomNavigationScreens( route = Routes.PantallaPrincipal.route, icon = Icons.Filled.Home , label = "Home")
    object Favorite:BottomNavigationScreens( route = Routes.PantallaFav.route , icon = Icons.Filled.Favorite , label = "Favoritos" )
}