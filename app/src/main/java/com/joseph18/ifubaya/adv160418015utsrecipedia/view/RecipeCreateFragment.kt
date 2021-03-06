package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeCreateViewModel
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeDetailViewModel
import kotlinx.android.synthetic.main.fragment_recipe_edit.*

class RecipeCreateFragment : Fragment() {
    private lateinit var viewModel : RecipeCreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeCreateViewModel::class.java)

        btnSaveRecipe.setOnClickListener() {
            var recipeToAdd = Recipe(
                txtEditTitle.text.toString(),
                txtEditDescription.text.toString(),
                txtEditURLphoto.text.toString(),
            )
            viewModel.addRecipe(recipeToAdd)

            Toast.makeText(it.context, "Recipe Created", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {

        })
    }
}