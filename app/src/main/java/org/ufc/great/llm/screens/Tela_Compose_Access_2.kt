package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("DEPRECATION")
class Tela_Compose_Access_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListScreen()
        }
    }

    data class Task(
        val id: Int,
        val description: String,
        val date: Date,
        var isChecked: Boolean
    )

    @Composable
    fun TaskListScreen() {
        val tasks = remember {
            mutableStateListOf(
                Task(1, "Tarefa 1", Date(124, 6, 18), false),
                Task(2, "Tarefa 2", Date(124, 6, 19), false),
                Task(3, "Tarefa 3", Date(124, 6, 20), false)
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

    @Composable
    fun TaskItem(task: Task) {
        var isChecked by remember { mutableStateOf(task.isChecked) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .semantics {
                    contentDescription = "${task.description}, ${SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.date)}"
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.semantics {
                        contentDescription = "Tarefa: ${task.description}"
                    }
                )
                Text(
                    text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.date),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.semantics {
                        contentDescription = "Data: ${SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(task.date)}"
                    }
                )
            }
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    task.isChecked = it
                },
                modifier = Modifier.semantics {
                    contentDescription = if (isChecked) "Checkbox marcado" else "Checkbox desmarcado"
                }
            )
        }
    }


    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        TaskListScreen()
    }
}