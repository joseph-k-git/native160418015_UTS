package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.util.Util.Companion.loadImage
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeDetailViewModel
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

class RecipeDetailFragment : Fragment() {
    private lateinit var viewModel :RecipeDetailViewModel

    private lateinit var recipe :Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeDetailViewModel::class.java)
        viewModel.fetch(RecipeDetailFragmentArgs.fromBundle(requireArguments()).recipeId)

        observeViewModel()

        btnEdit.setOnClickListener() {
            val action = RecipeDetailFragmentDirections.actionRecipeDetailFragmentToRecipeEditFragment(recipeId = recipe.uuid)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            recipe = it
            txtId2.setText(it.uuid.toString())
            txtName2.setText(it.name)
            txtDescription2.setText(it.description)
            imageView2.loadImage(it.photoUrl.toString(), progressBar2)
        })
    }
}