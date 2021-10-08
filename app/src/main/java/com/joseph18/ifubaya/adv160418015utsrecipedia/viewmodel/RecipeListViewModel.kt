package com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe

class RecipeListViewModel(application: Application): AndroidViewModel(application) {
    val recipesLD = MutableLiveData<List<Recipe>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingErrorLD.value = false
        loadingLD.value = true

        recipesLD.value = Recipe.getMockRecipes();

        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}