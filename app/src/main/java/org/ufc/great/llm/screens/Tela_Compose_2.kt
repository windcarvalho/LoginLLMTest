package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

class Tela_Compose_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListScreen(
                tasks = listOf(
                    Task("Comprar leite", "2024-04-05"),
                    Task("Ligar para o médico", "2024-04-07"),
                    Task("Fazer exercícios", "2024-04-10")
                )
            )
        }
    }

    data class Task(val name: String, val date: String)

    @Composable
    fun TaskListScreen(tasks: List<Task>) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column {
                TaskList(tasks = tasks)
            }
        }
    }

    @Composable
    fun TaskList(tasks: List<Task>) {
        LazyColumn {
            items(tasks) { task ->
                TaskListItem(task = task)
            }
        }
    }

    @Composable
    fun TaskListItem(task: Task) {
        Column {
            Text(text = task.name)
            Text(text = task.date)
            Checkbox(checked = false, onCheckedChange = { /*TODO*/ })
        }
    }

    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        Tela_Compose_2()
    }
}

//COLAR