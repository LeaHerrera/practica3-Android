package com.example.favoritos.view.Detail.view

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.favoritos.model.id.DrinkID

@Composable
fun infoDrink(drink: DrinkID){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(2.dp, Color.Black)
                .padding(5.dp)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.25f)

        ){

            Text(text = "Category: " + drink.strCategory )
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

