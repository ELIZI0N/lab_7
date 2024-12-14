package com.example.lab_6

data class MealList(
    val meals: List<Meal>
)

data class Meal(
    val strMealThumb: String,
    val strMeal: String,
    val strArea: String,
    val strInstructions: String
)