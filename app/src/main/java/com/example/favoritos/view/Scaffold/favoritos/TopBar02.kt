package com.example.favoritos.view.Scaffold.favoritos

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarF(titulo:String) {
    TopAppBar(
        title = { Text(text = titulo, fontWeight = FontWeight.Black, fontSize = 30.sp) },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Magenta,
            titleContentColor = Color.White
        )
    )
}
