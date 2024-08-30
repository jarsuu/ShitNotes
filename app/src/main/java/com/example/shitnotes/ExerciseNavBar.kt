package com.example.shitnotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseCategoryNavBar() {
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
            RoutineDropdownMenu()
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    /*TODO: Add exercise*/
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "AddExercise",
                    modifier = Modifier.size(32.dp),
                    tint = Color.White
                )
            }

            ExerciseCategorySettingsMenu()
        }
    }
}

@Composable
fun ExerciseCategorySettingsMenu() {
    var expanded by remember { mutableStateOf(false) }
    var isColoursChecked by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { expanded = true }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "CategorySettingsMenu",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(172.dp)
                .background(Color.DarkGray)
        ) {
            HorizontalDivider()
            DropdownMenuItem(
                text = { Text("Colours", fontSize = 16.sp, color = Color.White) },
                onClick = {
                    isColoursChecked = !isColoursChecked
                },
                leadingIcon = null,
                trailingIcon = {
                    Checkbox(
                        checked = isColoursChecked,
                        onCheckedChange = null,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.White,
                        )
                    )
                }
            )
            HorizontalDivider()
            DropdownMenuItem(
                text = { Text("Reorder", fontSize = 16.sp, color = Color.White) },
                onClick = { /* Handle settings! */ },
            )
            HorizontalDivider()
        }
    }
}

@Composable
fun ExerciseNavBar() {
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
            RoutineDropdownMenu()
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    /*TODO: Add exercise*/
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "AddExercise",
                    modifier = Modifier.size(32.dp),
                    tint = Color.White
                )
            }

            ExerciseSettingsMenu()
        }
    }
}

@Composable
fun ExerciseSettingsMenu() {
    var expanded by remember { mutableStateOf(false) }
    var isWorkoutCountChecked by remember {
        mutableStateOf(false)
    }
    var isLastUsedChecked by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { expanded = true }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "CategorySettingsMenu",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(172.dp)
                .background(Color.DarkGray)
        ) {
            HorizontalDivider()
            DropdownMenuItem(
                text = { Text("Workout Count", fontSize = 16.sp, color = Color.White) },
                onClick = {
                    isWorkoutCountChecked = !isWorkoutCountChecked
                },
                leadingIcon = null,
                trailingIcon = {
                    Checkbox(
                        checked = isWorkoutCountChecked,
                        onCheckedChange = null,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.White,
                        )
                    )
                }
            )
            HorizontalDivider()
            DropdownMenuItem(
                text = { Text("Last Used", fontSize = 16.sp, color = Color.White) },
                onClick = {
                    isLastUsedChecked = !isLastUsedChecked
                },
                leadingIcon = null,
                trailingIcon = {
                    Checkbox(
                        checked = isLastUsedChecked,
                        onCheckedChange = null,
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.White,
                        )
                    )
                }
            )
            HorizontalDivider()
        }
    }
}