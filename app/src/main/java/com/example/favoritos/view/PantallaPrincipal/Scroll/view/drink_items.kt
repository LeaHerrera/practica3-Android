package com.example.favoritos.view.PantallaPrincipal.Scroll.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.model.lista.DrinkCategorie
import com.example.favoritos.navigation.Routes
import com.example.favoritos.viewmodel.APIViewModel


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemsByCategory(drink: DrinkCategorie, navigation: NavHostController, api: APIViewModel) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ){
            GlideImage(
                model = drink.strDrinkThumb,
                contentDescription = "Character Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
            Column {
                Text(
                    text = drink.strDrink,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize()
                )
                Button(onClick = {
                    api.setId(drink.idDrink)
                    navigation.navigate(Routes.PantallaInfo.route)
                    api.setResetLoading()
                }) {
                    Text(text = "HOLA")
                }
            }


        }
    }
}
