package com.tcs.MealSuggestion.Meal

data class Meal(
    val id : Int,
    val name : String,
    val ingredients : List<String>,
    val attributes : MutableList<String>,
    val description : String,
    ) {
}