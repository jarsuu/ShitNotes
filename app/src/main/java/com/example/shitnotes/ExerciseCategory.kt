package com.example.shitnotes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    val categoryList = listOf(
        "Chest",
        "Back",
        "Biceps",
        "Triceps",
        "longlonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglong"
    )
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
        ExerciseCategoryNavBar(
            onSettingsClick = {
                println("Category settings clicked")
            }
        )
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

@Composable
fun ExerciseCategoryNavBar(
    onSettingsClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            /*TODO: Add logo*/
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Logo",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            /*TODO: Dropdown menu*/
            ExerciseCategoryDropdownMenu()
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(1.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "AddExercise",
                    modifier = Modifier.size(32.dp)
                )
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(1.dp),
                onClick = onSettingsClick
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Settings",
                    modifier = Modifier.size(32.dp)
                )
            }
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
@OptIn(ExperimentalMaterial3Api::class)
fun ExerciseCategoryDropdownMenu() {
    val options = listOf("Option 1", "Option 2", "Option 3")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .width(164.dp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("example") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                )
            }
        }
    }
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

/*TODO: Handle fetching exercises*/
fun fetchExercises(category: String?): List<String> {
    return when (category) {
        "Chest" -> listOf(
            "Barbell bench press",
            "Push up",
            "Incline dumbbell bench press",
            "Pec Deck"
        )

        "Back" -> listOf(
            "Pull up",
            "Lat pulldown",
            "Cable row",
            "Dumbbell row",
            "Barbell row",
            "T-bar row"
        )

        /*TODO: Handle empty case*/
        else -> listOf("No exercises found")
    }
}