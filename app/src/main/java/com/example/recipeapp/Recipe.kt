package com.example.recipeapp

data class Recipe(
    val title: String,
    val description: String,
    val imageResId: Int,
    var isFavorite: Boolean = false
)
