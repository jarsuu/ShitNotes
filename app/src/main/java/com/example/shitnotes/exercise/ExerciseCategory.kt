package com.example.shitnotes.exercise

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExerciseCategory(
    navController: NavController,
    exerciseListViewModel: ExerciseListViewModel
) {
    /*TODO: Fetch categories*/
    val categoryList = fetchCategories()
    val searchText by exerciseListViewModel.searchText.collectAsState()
    val exercises by exerciseListViewModel.exercises.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*TODO: Set category settings*/
        ExerciseCategoryNavBar()
        ExerciseSearchBar(searchText = searchText, onSearchTextChange = { searchText ->
            exerciseListViewModel.onSearchTextChange(searchText)
        })

        if (searchText.isBlank()) {
            ExerciseCategoryDisplayedItems(
                itemsList = categoryList,
                onItemClick = { category ->
                    navController.navigate("exercise-category/$category")
                },
                /*TODO: Handle category option click*/
                onItemOptionClick = { category ->
                    println("$category options clicked")
                })
        } else {
            ExerciseCategoryDisplayedItems(
                itemsList = exercises.map { it.name },
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
}

/*TODO: Handle exercise search*/
@Composable
fun ExerciseSearchBar(searchText: String, onSearchTextChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "ExerciseSearch")
        },
        trailingIcon = {
            if (searchText.isNotBlank()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "ExerciseSearchClear",
                    Modifier.clickable {
                        onSearchTextChange("")
                    })
            }
        },
        value = searchText,
        onValueChange = {
            onSearchTextChange(it)
        },
    )
}

@Composable
fun ExerciseCategoryDisplayedItems(
    itemsList: List<String>,
    onItemClick: (String) -> Unit,
    onItemOptionClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(itemsList) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "CategoryOptions",
                    modifier = Modifier
                        .clickable {
                            onItemOptionClick(item)
                        }
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                )
            }
            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

/*TODO: Fetch categories*/
fun fetchCategories(): List<String> {
    val categoryList = listOf(
        "Chest",
        "Back",
        "Biceps",
        "Triceps",
        "longlonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglong"
    )

    return categoryList
}