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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun ExerciseCreation(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
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

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
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
        )
//        Column(modifier = Modifier.padding(8.dp).height(64.dp)) {
//            BasicTextField(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 10.dp),
//                value = name,
//                onValueChange = { name = it },
//                textStyle = TextStyle(
//                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
//                    fontSize = 18.sp
//                )
//            )
//            HorizontalDivider()
//        }

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
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
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
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
        )

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
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
        )

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
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
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