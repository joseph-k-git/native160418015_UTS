package com.joseph18.ifubaya.adv160418015utsrecipedia.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.Recipe
import com.joseph18.ifubaya.adv160418015utsrecipedia.model.RecipeDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecipeDetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope
{
    val recipeLD = MutableLiveData<Recipe>()

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

    fun fetch(id :Int) {
        launch {
            val db = buildDatabase()
            recipeLD.value = db.recipeDao().getById(id)
        }
    }

    fun deleteRecipe(recipeToDelete :Recipe) {
        launch {
            val db = buildDatabase()
            db.recipeDao().deleteRecipe(recipeToDelete)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}