package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Tela_Compose_2 : AppCompatActivity() {

    data class Task(
        val id: Int,
        val description: String,
        val date: Date,
        var isChecked: Boolean
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListTheme {
                TaskListScreen()
            }
        }
    }

    @Composable
    fun TaskItem(task: Task) {
        var isChecked by remember { mutableStateOf(task.isChecked) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                BasicText(text = task.description, style = MaterialTheme.typography.bodyLarge)
                BasicText(
                    text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.date),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    task.isChecked = it
                }
            )
        }
    }

    @Composable
    fun TaskListScreen() {
        val tasks = remember {
            mutableStateListOf(
                Task(1, "Tarefa 1", Date(2024, 6, 18), false),
                Task(2, "Tarefa 2", Date(2024, 6, 19), false),
                Task(3, "Tarefa 3", Date(2024, 6, 20), false)
            ).sortedByDescending { it.date }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(tasks) { task ->
                TaskItem(task = task)
            }
        }
    }

    private val LightColors = lightColorScheme(
        primary = Color(0xFF6200EE),
        secondary = Color(0xFF03DAC5),
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
    )

    @Composable
    fun TaskListTheme(content: @Composable () -> Unit) {
        MaterialTheme(
            colorScheme = LightColors,
            typography = MaterialTheme.typography,
            content = content
        )
    }


    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        TaskListTheme {
            TaskListScreen()
        }
    }
}

//COLAR