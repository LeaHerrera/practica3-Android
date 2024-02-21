package com.example.favoritos.view.Scroll

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.model.categorias.Categorias
import com.example.favoritos.model.categorias.Drink
import com.example.favoritos.model.lista.DataCategorie
import com.example.favoritos.model.lista.DrinkCategorie
import com.example.favoritos.navigation.Routes
import com.example.favoritos.viewmodel.APIViewModel


@Composable
fun ScreenScroll(navigation: NavHostController, apiViewModel: APIViewModel){
//RECYCLER VIEW
    val showLoading: Boolean by apiViewModel.loading.observeAsState(true)
    val showCategorias: Boolean by apiViewModel.mostrarCategoria.observeAsState(true)

    importAPI( apiViewModel , showCategorias )

    if(showLoading){
        Cargando()
    } else {
        ScrollItems(nav = navigation , api = apiViewModel , show = showCategorias)
    }
}

@Composable
fun ScrollItems(nav:NavHostController , api: APIViewModel , show: Boolean){
    val categorias: Categorias by api.characters.observeAsState(Categorias(emptyList()))
    val drinkCat: DataCategorie by api.dataCat.observeAsState(DataCategorie(emptyList()))

    if (show){
        LazyColumn() {
            items(categorias.drinks) {
                CharacterItem(Drink = it , apiViewModel = api)
            }
        }
    } else {
        LazyColumn() {
            items(drinkCat.drinks) {
                CategoryItems(drink = it , nav , api)
            }
        }
    }
}

fun importAPI(api:APIViewModel , show:Boolean){

    if (show){
        api.getCategory()
    } else {
        api.getIdCategory()
    }
}

@Composable
fun Cargando(){
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary
    )
}


@Composable
fun CharacterItem(Drink: Drink , apiViewModel: APIViewModel) {
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Text(
                text = Drink.strCategory,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize(0.5f)
            )
            Button(onClick = { apiViewModel.setCategorie(Drink) }) {
                Text(text = "hola")
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryItems(drink: DrinkCategorie , navigation: NavHostController , api: APIViewModel) {
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
                }) {
                    Text(text = "HOLA")
                }
            }


        }
    }
}
