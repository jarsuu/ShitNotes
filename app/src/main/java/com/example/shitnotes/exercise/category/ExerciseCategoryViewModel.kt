package com.example.shitnotes.exercise.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shitnotes.exercise.category.database.ExerciseCategory
import com.example.shitnotes.exercise.category.database.ExerciseCategoryDao
import com.example.shitnotes.exercise.category.database.ExerciseCategoryEvent
import com.example.shitnotes.exercise.category.database.ExerciseCategorySortType
import com.example.shitnotes.exercise.category.database.ExerciseCategoryState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ExerciseCategoryViewModel(
    private val dao: ExerciseCategoryDao
) : ViewModel() {
    private val _sortType = MutableStateFlow(ExerciseCategorySortType.ALPHABETICAL)
    private val _exerciseCategories = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                ExerciseCategorySortType.ALPHABETICAL -> dao.getExerciseCategoryAlphabetical()
                ExerciseCategorySortType.MANUAL -> dao.getExerciseCategoryManual()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _state = MutableStateFlow(ExerciseCategoryState())
    val state =
        combine(_state, _sortType, _exerciseCategories) { state, sortType, exerciseCategories ->
            state.copy(
                exerciseCategories = exerciseCategories,
                sortType = sortType
            )
        }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000), ExerciseCategoryState()
        )

    fun onEvent(event: ExerciseCategoryEvent) {
        when (event) {
            is ExerciseCategoryEvent.DeleteExerciseCategory -> {
                viewModelScope.launch {
                    dao.deleteExerciseCategory(event.exerciseCategory)
                }
            }

            ExerciseCategoryEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingExerciseCategory = false
                    )
                }
            }

            ExerciseCategoryEvent.SaveExerciseCategory -> {
                val name = state.value.name
                val colour = state.value.colour

                if (name.isBlank() || colour.isBlank()) {
                    return
                }

                val exerciseCategory = ExerciseCategory(
                    name = name,
                    colour = colour
                )
                viewModelScope.launch {
                    dao.insertExerciseCategory(exerciseCategory)
                }
                _state.update { it.copy(
                    isAddingExerciseCategory = false,
                    name = "",
                    colour = ""
                ) }
            }

            is ExerciseCategoryEvent.SetColour -> {
                _state.update {
                    it.copy(
                        colour = event.colour
                    )
                }
            }

            is ExerciseCategoryEvent.SetName -> {
                _state.update {
                    it.copy(
                        name = event.name
                    )
                }
            }

            ExerciseCategoryEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingExerciseCategory = true
                    )
                }
            }

            is ExerciseCategoryEvent.SortExerciseCategory -> {
                _sortType.value = event.sortType
            }
        }
    }
}