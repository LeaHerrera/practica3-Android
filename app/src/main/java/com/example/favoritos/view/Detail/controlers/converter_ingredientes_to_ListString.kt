package com.example.favoritos.view.Detail.controlers

import com.example.favoritos.model.id.DrinkID

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