package com.example.favoritos.view.Detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.model.id.Data
import com.example.favoritos.view.PantallaPrincipal.Scroll.view.Cargando
import com.example.favoritos.viewmodel.APIViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Detail(myViewModel: APIViewModel){

    myViewModel.getDrinkById()
    val drink: Data by myViewModel.idDrink.observeAsState(Data(emptyList()))

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        if(drink.drinks.isNotEmpty()){
            Text(text = drink.drinks[0].strDrink , )
            GlideImage(
                model = drink.drinks[0].strDrinkThumb,
                contentDescription = "Character Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
            Ingredientes(drink = drink.drinks[0])
            infoDrink(drink = drink.drinks[0])
        } else {
            Cargando()
        }
    }
}