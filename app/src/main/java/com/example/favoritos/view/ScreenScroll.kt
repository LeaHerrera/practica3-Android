package com.example.favoritos.view

import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.categorias.Drink
import com.example.favoritos.viewmodel.APIViewModel
import com.example.favoritos.viewmodel.ScrollViewModel


@Composable
fun ScreenScroll(navigation: NavHostController, APIViewModel: APIViewModel){
//RECYCLER VIEW
    val showLoading: Boolean by APIViewModel.loading.observeAsState(true)
    val Categorias: Categorias by APIViewModel.characters.observeAsState(Categorias(emptyList()))
    val scrollViewModel by viewModels<ScrollViewModel>()


    APIViewModel.getCharacters()
    if(showLoading){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
    else{
        LazyColumn() {
            items(Categorias.drinks) {
                CharacterItem(Drink = it)
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(Drink: Drink) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Text(
                text = Drink.strCategory,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/*

GlideImage(
model = Drink.strDrinkThumb,
contentDescription = "Character Image",
contentScale = ContentScale.Crop,
modifier = Modifier.size(100.dp)
)

 */