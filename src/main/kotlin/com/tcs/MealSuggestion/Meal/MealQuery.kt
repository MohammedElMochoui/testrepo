package com.tcs.MealSuggestion.Meal

data class MealQuery(val id : Int = 0,
                     val name : String = "",
                     val ingredients : List<String> = listOf<String>(),
                     val attributes : MutableList<String> = mutableListOf<String>(),
                     val description : String = "") {
}