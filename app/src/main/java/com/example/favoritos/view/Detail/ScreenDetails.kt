package com.example.favoritos.view.Detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.model.id.Data
import com.example.favoritos.model.id.DrinkID
import com.example.favoritos.view.Scroll.Cargando
import com.example.favoritos.viewmodel.APIViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScreenDetails(navigation: NavHostController, myViewModel: APIViewModel ){

    // myViewModel.setId(id)
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

@Composable
fun Ingredientes(drink: DrinkID){

    val ingredientes = strIntgredientes(drink = drink)

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Column {
            repeat(ingredientes.size) {
                Text(text = ingredientes[it])
            }
        }
    }

}

fun strIntgredientes(drink: DrinkID):Array<String>{

    val ingredientesMedidos:Array<String>

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
    var contadorIngredientes = 0

    repeat(ingredientes.size){
        if ( !ingredientes[it].isNullOrEmpty() ){
            contadorIngredientes++
        }
    }
    ingredientesMedidos = Array(contadorIngredientes){""}

    repeat(contadorIngredientes){
        if ( !mesures[it].isNullOrEmpty() ){
            ingredientesMedidos[it] = "${mesures[it]} by ${ingredientes[it]}"
        } else {
            ingredientesMedidos[it] = ingredientes[it]
        }
    }

    return ingredientesMedidos
}
@Composable
fun infoDrink(drink: DrinkID){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(2.dp, Color.Black)
                .padding(5.dp)
        ){

            Text(
                text = "Category: " + drink.strCategory ,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
            Text(text = "Alcoholic: " + drink.strAlcoholic)
            Text(
                text = "Glass: " + drink.strGlass ,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        if (!drink.strInstructionsES.isNullOrEmpty()){
            Text(text = drink.strInstructionsES)
        } else {
            Text(text = drink.strInstructions)
        }
    }
}

