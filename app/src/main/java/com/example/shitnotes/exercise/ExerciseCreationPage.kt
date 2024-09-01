package com.example.shitnotes.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExerciseCreationPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        ExerciseCreationNavBar(navController = navController)

        ExerciseCreationForm()
    }
}

@Composable
fun ExerciseCreationForm() {
    var name by remember {
        mutableStateOf("")
    }
    var notes by remember {
        mutableStateOf("")
    }
    var category by remember {
        mutableStateOf("")
    }
    var type by remember {
        mutableStateOf("")
    }
    var weightUnit by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        /*Name*/
        Text(
            text = "name".uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Gray
            ),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        HorizontalDivider(color = Color(0xFFCF7251))
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(32.dp))

        /*Notes*/
        Text(
            text = "notes (optional)".uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Gray
            ),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        HorizontalDivider(color = Color(0xFFCF7251))
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = notes,
            onValueChange = { notes = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(32.dp))

        /*Category*/
        Text(
            text = "category".uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Gray
            ),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        HorizontalDivider(color = Color(0xFFCF7251))
        ExerciseCreationCategoryDropdown(
            onCategoryChange = {
                category = it
            })

        Spacer(modifier = Modifier.height(32.dp))

        /*Type*/
        Text(
            text = "type".uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Gray
            ),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        HorizontalDivider(color = Color(0xFFCF7251))
        ExerciseCreationTypeDropdown(onTypeChange = {
            type = it
        })

        Spacer(modifier = Modifier.height(32.dp))

        /*Weight Unit*/
        Text(
            text = "weight unit".uppercase(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.White else Color.Gray
            ),
            modifier = Modifier.padding(bottom = 2.dp)
        )
        HorizontalDivider(color = Color(0xFFCF7251))
        ExerciseCreationWeightUnitDropdown(
            onWeightUnitChange = {
                weightUnit = it
            }
        )
    }
}

@Composable
fun ExerciseCreationNavBar(navController: NavController) {
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
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            /*TODO: Add logo*/
            Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.clickable {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .offset(x = (-16).dp),
                )

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Logo",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            Text(text = "New Exercise", fontSize = 18.sp, color = Color.White)
        }

        /*Confirm exercise creation*/
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    /*TODO: Add exercise*/
                    println()
                }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "CreateExercisePlus1",
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.Center),
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "CreateExerciseAdd",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterEnd)
                            .offset(y = 6.dp),
                        tint = Color.White
                    )
                }
            }

            IconButton(
                onClick = {
                    /*TODO: Add exercise*/
                    println()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "CreateExercisePlus2",
                    modifier = Modifier.size(32.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun ExerciseCreationCategoryDropdown(onCategoryChange: (String) -> Unit) {
    /*TODO: Fetch categories*/
    val options = listOf("", "Option 1", "Option 2", "Option 3")

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DropdownTemplate(
            options = options,
            onSelectChange = onCategoryChange,
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = {
            /*TODO: Implement add category*/
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "ExerciseCategoryAdd",
                tint = Color(0xFFCF7251),
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun ExerciseCreationTypeDropdown(onTypeChange: (String) -> Unit) {
    val options = listOf("Weight and reps", "Distance and time")
    DropdownTemplate(options = options, onSelectChange = onTypeChange)
}

@Composable
fun ExerciseCreationWeightUnitDropdown(onWeightUnitChange: (String) -> Unit) {
    val options = listOf("Default (kgs)", "Metric (kgs)", "Imperial (lbs)")
    DropdownTemplate(options = options, onSelectChange = onWeightUnitChange)
}