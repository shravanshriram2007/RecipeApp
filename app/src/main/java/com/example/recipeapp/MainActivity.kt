package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeList: ArrayList<Recipe>
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        bottomNav = findViewById(R.id.bottomNav)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recipeList = ArrayList()
        loadRecipes()

        recipeAdapter = RecipeAdapter(this, recipeList)
        recyclerView.adapter = recipeAdapter

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    recipeAdapter = RecipeAdapter(this, recipeList)
                    recyclerView.adapter = recipeAdapter
                }
                R.id.nav_favorites -> {
                    recipeAdapter = RecipeAdapter(this, FavoriteManager.favoriteRecipes)
                    recyclerView.adapter = recipeAdapter
                }
            }
            true
        }
    }

    private fun loadRecipes() {
        val recipes = listOf(
            Recipe("Spaghetti Carbonara", "Classic Italian pasta.", R.drawable.spaghetti),
            Recipe("Chocolate Cake", "Rich chocolate flavor.", R.drawable.chocolate_cake),
            Recipe("Caesar Salad", "Fresh and crisp.", R.drawable.caesar_salad)
        )
        recipeList.addAll(recipes)
    }
}