package com.example.favoritos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.favoritos.navigation.Routes
import com.example.favoritos.ui.theme.FavoritosTheme
import com.example.favoritos.view.Detail.ScreenDetails
import com.example.favoritos.view.Scroll.ScreenScroll
import com.example.favoritos.view.Splash.SplashScreen
import com.example.favoritos.viewmodel.APIViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavoritosTheme {

                val myViewModel by viewModels<APIViewModel>()
                val navigation = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavHost(
                        navController = navigation,
                        startDestination = Routes.PantallaSplash.route
                    ) {
                        composable(Routes.PantallaSplash.route) { SplashScreen(navigation) }
                        composable(Routes.PantallaPrincipal.route) { ScreenScroll(navigation, myViewModel) }
                        composable(Routes.PantallaInfo.route) { ScreenDetails(navigation, myViewModel) }
                    }
                }
            }
        }
    }
}

// https://www.thecocktaildb.com/api.php
