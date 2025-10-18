package com.example.recipeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private val context: Context,
    private val recipeList: List<Recipe>
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: CardView = itemView.findViewById(R.id.recipeCard)
        val image: ImageView = itemView.findViewById(R.id.recipeImage)
        val title: TextView = itemView.findViewById(R.id.recipeTitle)
        val favorite: ImageView = itemView.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.title.text = recipe.title
        holder.image.setImageResource(recipe.imageResId)
        holder.favorite.setImageResource(
            if (recipe.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        )

        holder.card.setOnClickListener {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra("title", recipe.title)
            intent.putExtra("description", recipe.description)
            intent.putExtra("imageResId", recipe.imageResId)
            context.startActivity(intent)
        }

        holder.favorite.setOnClickListener {
            recipe.isFavorite = !recipe.isFavorite
            if (recipe.isFavorite) FavoriteManager.favoriteRecipes.add(recipe)
            else FavoriteManager.favoriteRecipes.remove(recipe)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = recipeList.size
}