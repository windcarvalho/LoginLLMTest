package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cadastrollmtest.R

@Suppress("DEPRECATION")
class Tela_Compose_Access_2 : AppCompatActivity() {
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
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Lista de Tarefas",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = { /*TODO*/ },
//                contentDescription = "Concluir tarefa ${task.name}"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = task.name,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black // Melhorando o contraste
                )
                Text(
                    text = task.date,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray // Melhorando o contraste
                )
            }
        }
    }


    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        Tela_Compose_Access_2()
    }
}