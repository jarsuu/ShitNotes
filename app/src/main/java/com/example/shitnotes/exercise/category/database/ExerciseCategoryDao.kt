package com.example.shitnotes.exercise.category.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseCategoryDao {
    @Insert
    suspend fun insertExerciseCategory(exerciseCategory: ExerciseCategory)

    @Delete
    suspend fun deleteExerciseCategory(exerciseCategory: ExerciseCategory)

    @Query("SELECT * FROM exercise_category ORDER BY name ASC")
    fun getExerciseCategoryAlphabetical(): Flow<List<ExerciseCategory>>

    @Query("SELECT * FROM exercise_category")
    fun getExerciseCategoryManual(): Flow<List<ExerciseCategory>>
}