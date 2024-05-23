package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cadastrollmtest.R

@OptIn(ExperimentalMaterial3Api::class)
class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val tasks = remember {
                    listOf(
                        Task(1, "Comprar leite", "03/04/2024"),
                        Task(2, "Ligar para o cliente", "05/04/2024"),
                        Task(3, "Enviar relatório", "10/04/2024")
                    )
                }
                TaskListScreen(tasks = tasks)
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun TaskListScreen(tasks: List<Task>) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Lista de Tarefas") }
                )
            }
        ) {
            TaskList(tasks = tasks)
        }
    }

    @Composable
    fun TaskList(tasks: List<Task>) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(tasks) { task ->
                TaskListItem(task = task)
            }
        }
    }

    @Composable
    fun TaskListItem(task: Task) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = task.taskName,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Data de Vencimento: ${task.dueDate}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Checkbox(
                    checked = false,
                    onCheckedChange = { /* TODO: Handle checkbox state */ },
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }

    data class Task(val id: Int, val taskName: String, val dueDate: String)

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            Tela_Compose_1()
        }
    }

}