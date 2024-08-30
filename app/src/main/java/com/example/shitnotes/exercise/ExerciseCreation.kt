package com.example.shitnotes.exercise

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseCreation() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
    ) {
        ExerciseCreationNavBar()

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