package com.example.favoritos.view

import android.webkit.ConsoleMessage
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.model.id.Data
import com.example.favoritos.model.id.DrinkID
import com.example.favoritos.model.lista.DataCategorie
import com.example.favoritos.viewmodel.APIViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScreenDetails(navigation: NavHostController, myViewModel: APIViewModel , id:String){

    myViewModel.setId(id)
    myViewModel.getIdDrink()
    val drinkId: Data by myViewModel.idDrink.observeAsState(Data(emptyList()))

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Text(text = id + "fff")
        /*
        GlideImage(
            model = drinkId.drinks[0].strDrinkThumb,
            contentDescription = "Character Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp)
        )
*/
    }

}
/*
@Composable
fun Ingredientes(drink:DrinkID){

    val ingredientes:List<String> = listOf(
        drink.strIngredient1 , drink.strIngredient2 , drink.strIngredient3 , drink.strIngredient4, drink.strIngredient5 ,
        drink.strIngredient6 , drink.strIngredient7 , drink.strIngredient8 , drink.strIngredient9 , drink.strIngredient10 ,
        drink.strIngredient11 , drink.strIngredient12 , drink.strIngredient13 , drink.strIngredient14 , drink.strIngredient15
    )
    val mesures:List<String> = listOf(
        drink.strMeasure1 , drink.strMeasure2 , drink.strMeasure3 , drink.strMeasure4, drink.strMeasure5 ,
        drink.strMeasure6 , drink.strMeasure7 , drink.strMeasure8 , drink.strMeasure9 , drink.strMeasure10 ,
        drink.strMeasure11 , drink.strMeasure12 , drink.strMeasure13 , drink.strMeasure14 , drink.strMeasure15
    )

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Column {
            repeat(15){
                if ( !mesures[it].isNullOrEmpty() ){
                    Text(text = mesures[it])
                }
            }
        }
        Column {
            repeat(15){
                if ( !ingredientes[it].isNullOrEmpty() ){
                    Text(text = ingredientes[it])
                }
            }
        }
    }

}
*/
