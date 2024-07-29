package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val tasks = remember {
                        mutableStateListOf(
                            Task("Learn Jetpack Compose", LocalDate.now(), false),
                            Task("Grocery Shopping", LocalDate.now().minusDays(1), false),
                            Task("Read a Book", LocalDate.now().minusDays(2), false)
                        )
                    }
                    TaskList(tasks = tasks)
                }
            }
        }
    }

    data class Task(val description: String, val date: LocalDate, var isDone: Boolean)

    @Composable
    fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = task.description)
                Text(text = task.date.toString(), style = MaterialTheme.typography.bodySmall)
            }
            Checkbox(checked = task.isDone, onCheckedChange = onCheckedChange)
        }
    }

    @Composable
    fun TaskList(tasks: List<Task>) {
        LazyColumn {
            items(tasks.sortedByDescending { it.date }) { task ->
                TaskItem(task = task, onCheckedChange = { isChecked ->
                    task.isDone = isChecked
                })
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        TaskListTheme {
            val tasks = listOf(
                Task("Learn Jetpack Compose", LocalDate.now(), false),
                Task("Grocery Shopping", LocalDate.now().minusDays(1), false),
                Task("Read a Book", LocalDate.now().minusDays(2), false)
            )
            TaskList(tasks = tasks)
        }
    }

    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

// ui.theme/Shape.kt

    val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

// ui.theme/Theme.kt

    private val DarkColorPalette = darkColorScheme(
        primary = Purple200,
        secondary = Teal200
    )

    private val LightColorPalette = lightColorScheme(
        primary = Purple500,
        secondary = Teal200
    )

    @Composable
    fun TaskListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

// ui.theme/Type.kt
    val Typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

}