package com.example.favoritos.view.Detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.favoritos.model.id.DrinkID
import com.example.favoritos.view.Detail.controlers.strIntgredientes

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
