package com.example.recipeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val title: TextView = findViewById(R.id.detailTitle)
        val description: TextView = findViewById(R.id.detailDescription)
        val image: ImageView = findViewById(R.id.detailImage)

        val recipeTitle = intent.getStringExtra("title")
        val recipeDescription = intent.getStringExtra("description")
        val recipeImage = intent.getIntExtra("imageResId", 0)

        title.text = recipeTitle
        description.text = recipeDescription
        image.setImageResource(recipeImage)
    }
}
