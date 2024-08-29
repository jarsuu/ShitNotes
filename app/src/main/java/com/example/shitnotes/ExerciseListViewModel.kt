package com.example.shitnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class ExerciseListViewModel: ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _exercises = MutableStateFlow(allExercises)
    val exercises = searchText
        .combine(_exercises) { text, exercises ->
            if (text.isBlank()) {
                exercises
            } else {
                exercises.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _exercises.value
        )


    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

data class Exercise(
    val name: String,
    val category: String,
    val type: String,
    val weightUnit: String,
    val notes: String?,
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val queryWords = query.split(" ")

        return queryWords.all { word ->
            name.contains(word, ignoreCase = true)
        }
    }
}

/*TODO: Replace stub exercises with fetch */
private val allExercises = listOf(
    Exercise(
        name = "Bench press",
        category = "Chest",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
    Exercise(
        name = "Incline bench press",
        category = "Chest",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
    Exercise(
        name = "Chest fly",
        category = "Chest",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
    Exercise(
        name = "Pull up",
        category = "Back",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
    Exercise(
        name = "Barbell row",
        category = "Back",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
    Exercise(
        name = "Cable row",
        category = "Back",
        type = "wr",
        weightUnit = "kg",
        notes = ""
    ),
)

