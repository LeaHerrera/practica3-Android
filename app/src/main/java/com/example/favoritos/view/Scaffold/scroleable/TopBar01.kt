package com.example.favoritos.view.Scaffold.scroleable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.favoritos.viewmodel.APIViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarS(titulo: String, api: APIViewModel, show: Boolean) {
    TopAppBar(
        title = { Text(text = titulo, fontWeight = FontWeight.Black, fontSize = 30.sp) },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Magenta,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(
                onClick = {
                    if (!show){
                        api.setOcultar()
                    } else if ( api.getCategoria() != "" ){
                        api.setCategorie()
                    }
                }
            ){
               if (!show){
                   Icon(imageVector = Icons.Default.KeyboardArrowLeft , contentDescription = "volver" )
               } else if ( api.getCategoria() != "" ){
                   Icon(imageVector = Icons.Default.KeyboardArrowRight , contentDescription = "volver" )
               }
            }
        }
    )
}