package com.joseph18.ifubaya.adv160418015utsrecipedia.model

import androidx.room.*

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe :Recipe) // vararg can be one or multiple Recipe(s)

    @Query("SELECT * FROM recipe")
    suspend fun fetchAll() :List<Recipe>

    @Query("SELECT * FROM recipe WHERE uuid = :id")
    suspend fun getById(id :Int) :Recipe

    @Query("UPDATE recipe SET name = :name, description = :description, photoUrl = :photoUrl WHERE uuid = :id")
    suspend fun edit(name :String, description :String, photoUrl :String, id :Int)

    @Delete
    suspend fun deleteRecipe(recipe :Recipe)
}