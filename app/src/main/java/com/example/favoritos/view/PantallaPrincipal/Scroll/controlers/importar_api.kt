package com.example.favoritos.view.PantallaPrincipal.Scroll.controlers

import com.example.favoritos.viewmodel.APIViewModel

fun importAPI(api: APIViewModel, show:Boolean){

    if (show){
        api.getCategory()
    } else {
        api.getIdCategory()
    }
}


