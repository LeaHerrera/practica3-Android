package com.example.favoritos.navigation

sealed class Routes(val route: String) {
    object PantallaSplash: Routes("splash_screen")
    object PantallaPrincipal: Routes("principal_screen")
    object PantallaInfo: Routes("info_screen")

}
