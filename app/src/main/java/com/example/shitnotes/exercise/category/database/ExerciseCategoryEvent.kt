package com.example.shitnotes.exercise.category.database

sealed interface ExerciseCategoryEvent {
    data object SaveExerciseCategory : ExerciseCategoryEvent
    data class SetName(val name: String) : ExerciseCategoryEvent
    data class SetColour(val colour: String) : ExerciseCategoryEvent
    data object ShowDialog : ExerciseCategoryEvent
    data object HideDialog : ExerciseCategoryEvent
    data class SortExerciseCategory(val sortType: ExerciseCategorySortType) : ExerciseCategoryEvent
    data class DeleteExerciseCategory(val exerciseCategory: ExerciseCategory) :
        ExerciseCategoryEvent

}