package com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.RecipeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecipeListViewModel(application :Application): AndroidViewModel(application), CoroutineScope {
    val recipesLD = MutableLiveData<List<Recipe>>()

    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext :CoroutineContext
        get() = job + Dispatchers.Main

    private fun buildDatabase(): RecipeDatabase {
        return Room.databaseBuilder(
            getApplication(),
            RecipeDatabase::class.java,
            "recipedia_db",
        ).build()
    }

    fun refresh() {
        loadingErrorLD.value = false
        loadingLD.value = true

        launch {
            val db = buildDatabase()
            recipesLD.value = db.recipeDao().fetchAll()
        }

        loadingLD.value = false
    }

    fun removeRecipe(recipeToDelete :Recipe) {
        launch {
            val db = buildDatabase()
            db.recipeDao().deleteRecipe(recipeToDelete)
            recipesLD.value = db.recipeDao().fetchAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}