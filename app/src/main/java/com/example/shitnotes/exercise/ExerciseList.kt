package com.example.shitnotes.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ExerciseList(
    navController: NavController,
    exerciseListViewModel: ExerciseListViewModel,
    category: String?
) {
    val searchText by exerciseListViewModel.searchText.collectAsState()
    val exercises by exerciseListViewModel.exercises.collectAsState()
    val filteredExercises = exercises.filter { it.category == category }

    val displayedExercises = if (searchText.isBlank()) {
        filteredExercises
    } else {
        filteredExercises.filter { it.doesMatchSearchQuery(searchText) }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*TODO: Set exercise settings*/
        ExerciseNavBar(navController)
        ExerciseSearchBar(searchText = searchText, onSearchTextChange = { searchText ->
            exerciseListViewModel.onSearchTextChange(searchText)
        })

        /*Exercise list*/
        ExerciseCategoryDisplayedItems(
            itemsList = displayedExercises.map { it.name },
            onItemClick = { exercise ->
                /*TODO: Handle exercise click*/
                println("$exercise clicked")
            },
            onItemOptionClick = { exercise ->
                /*TODO: Handle exercise options click*/
                println("$exercise options clicked")
            })
    }
}

