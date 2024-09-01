package com.example.shitnotes.exercise.category.database

data class ExerciseCategoryState(
    val exerciseCategories: List<ExerciseCategory> = emptyList(),
    val name: String = "",
    val colour: String = "",
    val isAddingExerciseCategory: Boolean = false,
    val sortType: ExerciseCategorySortType = ExerciseCategorySortType.ALPHABETICAL
)
