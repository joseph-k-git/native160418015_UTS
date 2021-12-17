package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.util.Util.Companion.loadImage
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipeListAdapter(private val recipeList :ArrayList<Recipe>): RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {
    class RecipeViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeListAdapter.RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val _v = inflater.inflate(R.layout.recipe_list_item, parent, false)

        return RecipeViewHolder(_v)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.txtId.text = recipeList[position].uuid.toString()
        holder.view.txtName.text = recipeList[position].name
        holder.view.imageView.loadImage(recipeList[position].photoUrl.toString(), holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener() {
            val action = RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment(recipeId = Integer.parseInt(holder.view.txtId.text.toString()))
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size;
    }

    fun updateRecipeList(newStudentList :List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(newStudentList)

        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(view: View) {
        val action = RecipeListFragmentDirections.actionRecipeListFragmentToRecipeDetailFragment(recipeId = Integer.parseInt(view.tag.toString()))
        Navigation.findNavController(view).navigate(action)
    }
}