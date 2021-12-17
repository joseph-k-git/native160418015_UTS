package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
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
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.util.Util.Companion.loadImage
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeCreateViewModel
import com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel.RecipeEditViewModel
import kotlinx.android.synthetic.main.fragment_recipe_detail.*
import kotlinx.android.synthetic.main.fragment_recipe_edit.*

class RecipeEditFragment : Fragment() {
    private lateinit var viewModel : RecipeEditViewModel

    private lateinit var recipeToEdit :Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeEditViewModel::class.java)
        viewModel.fetch(RecipeEditFragmentArgs.fromBundle(requireArguments()).recipeId)

        observeViewModel()

        btnSaveRecipe.setOnClickListener() {
            recipeToEdit.name = txtEditTitle.text.toString()
            recipeToEdit.description = txtEditDescription.text.toString()
            recipeToEdit.photoUrl = txtEditURLphoto.text.toString()

            viewModel.editRecipe(recipeToEdit)

            Toast.makeText(it.context, "Recipe Edited", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            recipeToEdit = it
            txtEditTitle.setText(it.name)
            txtEditDescription.setText(it.description)
            txtEditURLphoto.setText(it.photoUrl)
        })
    }
}