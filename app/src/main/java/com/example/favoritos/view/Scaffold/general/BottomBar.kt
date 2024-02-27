package com.example.favoritos.view.Scaffold.general

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.favoritos.model.BotomNavigation.BottomNavigationScreens


@Composable
fun MyBottomBar(nav: NavHostController, items: List<BottomNavigationScreens>) {
    BottomNavigation(backgroundColor = Color.Magenta) {
        val navBackStackEntry by nav.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route){
                        nav.navigate(item.route)
                    }
                },
                icon = { Icon(imageVector = item.icon , contentDescription = item.label) },
                label = { Text(text = item.label ) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black ,
                alwaysShowLabel = false
            )
        }
    }
}
