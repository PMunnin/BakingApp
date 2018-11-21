package com.example.android.bakingapp.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import com.example.android.bakingapp.ingredient.Ingredient;
import com.example.android.bakingapp.recipe.Recipe;
import com.example.android.bakingapp.step.RecipeStep;

@Dao
public interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecipes(List<Recipe> recipes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecipe(Recipe recipe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIngredients(List<Ingredient> ingredients);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSteps(List<RecipeStep> steps);

    @Query("SELECT * FROM " + RecipesDbContract.RECIPE_TABLE_NAME)
    List<Recipe> getRecipes();

    @Query("SELECT * FROM " + RecipesDbContract.RECIPE_TABLE_NAME + " WHERE id=:id")
    Recipe getRecipe(int id);

    @Query("SELECT * FROM " + RecipesDbContract.INGREDIENT_TABLE_NAME + " WHERE recipeId=:recipeId")
    List<Ingredient> getIngredients(int recipeId);

    @Query("SELECT * FROM " + RecipesDbContract.RECIPESTEP_TABLE_NAME + " WHERE _recipeId=:recipeId")
    List<RecipeStep> getSteps(int recipeId);

    @Query("DELETE FROM " + RecipesDbContract.RECIPE_TABLE_NAME)
    void deleteRecipes();
}
