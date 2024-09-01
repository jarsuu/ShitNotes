package com.example.shitnotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RoutineDropdownMenu() {
    /*TODO: Fetch routines*/
    val options = listOf("All exercises", "Option 2", "Option 3", "Create new routine")

    /*TODO: Fix up UI on larger lists*/
//    val manyoptions = List(100) { options[it % options.size] }

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .width(240.dp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            trailingIcon = {
                CompositionLocalProvider(LocalContentColor provides Color.White) {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                }
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedContainerColor = Color.Black,
                focusedContainerColor = Color.Black
            ),
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.DarkGray)
        ) {
            options.forEachIndexed { index, selectionOption ->
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
                DropdownMenuItem(
                    text = {
                        Text(
                            selectionOption,
                            fontSize = 16.sp,
                            fontWeight = if (index == 0 || index == options.size - 1) FontWeight.Bold
                            else FontWeight.Normal,
                            color = Color.White
                        )
                    },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                )
            }
        }
    }
}