package com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe

class RecipeDetailViewModel(application: Application): AndroidViewModel(application)
{
    val recipeLD = MutableLiveData<Recipe>()

    fun fetch(id:Int) {
        recipeLD.value = (Recipe.getMockRecipes())[id];
    }

    override fun onCleared() {
        super.onCleared()
    }
}