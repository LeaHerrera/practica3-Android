package com.example.favoritos.view.PantallaPrincipal.Scroll.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.GlideImage
import com.example.favoritos.view.Detail.view.Ingredientes
import com.example.favoritos.view.Detail.view.infoDrink

@Composable
fun Cargando(){

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp).fillMaxWidth(0.6f),
            color = MaterialTheme.colorScheme.secondary,
            strokeWidth = 8.dp
        )
    }


}
