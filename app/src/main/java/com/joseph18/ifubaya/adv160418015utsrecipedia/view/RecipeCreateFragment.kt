package com.joseph18.ifubaya.adv160418015utsrecipedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import kotlinx.android.synthetic.main.fragment_recipe_edit.*

class RecipeCreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSaveRecipe.setOnClickListener() {
            Navigation.findNavController(it).popBackStack()
        }
    }
}