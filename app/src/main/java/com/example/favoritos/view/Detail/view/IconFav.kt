package com.example.favoritos.view.Detail.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.favoritos.model.lista.DrinkByCategorie
import com.example.favoritos.viewmodel.APIViewModel

@Composable
fun IconFavoritos(apiViewModel: APIViewModel){
    val isFavory:Boolean by apiViewModel.isFavorite.observeAsState(false)
    val drink: DrinkByCategorie by apiViewModel.drinkByCategorie.observeAsState(DrinkByCategorie("","",""))
    val iconFav: ImageVector by apiViewModel.iconFavory.observeAsState(Icons.Default.FavoriteBorder)
    apiViewModel.isFavorite(drink.idDrink)

    Row {
        Spacer(modifier = Modifier.fillMaxWidth(0.5f))
        Icon(
            imageVector = iconFav,
            contentDescription = "favoritos",
            tint = Color.Red,
            modifier = Modifier
                .clickable {
                    if (isFavory){
                        apiViewModel.vaciarCorazon()
                        apiViewModel.deleteFavorite(drink)
                    } else {
                        apiViewModel.llenarCorazon()
                        apiViewModel.saveAsFavorite(drink)
                    }
                }
        )
    }

}