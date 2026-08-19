package com.example.examapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ExamScreen()
                }
            }
        }
    }
}

@Composable
fun ExamScreen() {
    var selectedOption by remember { mutableStateOf(-1) }
    val options = listOf("Dhaka", "Chittagong", "Sylhet", "Rajshahi")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Question 1: What is the capital of Bangladesh?",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = (selectedOption == index),
                    onClick = { selectedOption = index }
                )
                Text(text = option, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* Submit action */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedOption != -1
        ) {
            Text("Submit Answer")
        }
    }
}
