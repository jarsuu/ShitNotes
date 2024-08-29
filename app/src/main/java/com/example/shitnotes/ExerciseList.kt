package com.example.shitnotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ExerciseList(navController: NavController, category: String?) {
    val exercises = fetchExercises(category)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*TODO: Set exercise settings*/
        ExerciseCategoryNavBar(
            onSettingsClick = {
                println("Exercise settings clicked")
            }
        )
        ExerciseSearchBar()

        /*Exercise list*/
        ExerciseCategoryDisplayedItems(
            itemsList = exercises ?: listOf(),
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

