package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                TaskListScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Tarefas") }
            )
        },
        content = {
            TaskList()
        }
    )
}

@Composable
fun TaskItem(task: Task, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .focusable()
            .clickable(enabled = true, onClickLabel = "Concluir tarefa", onClick = {/*TODO: update this*/}),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { /* TODO: Implementar lógica de marcado */ },
            modifier = Modifier.padding(end = 16.dp)
//            contentDescription = "Marcar tarefa como concluída"
        )
        Column {
            Text(
                text = task.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .semantics {
                        contentDescription = "Nome da tarefa: ${task.name}"
                    }
            )
            Text(
                text = task.date,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.semantics {
                    contentDescription = "Data da tarefa: ${task.date}"
                }
            )
        }
    }
}

@Composable
fun TaskList() {
    val tasks = remember {
        mutableStateOf(
            listOf(
                Task("Fazer compras", "2024-04-05"),
                Task("Estudar para o exame", "2024-04-04"),
                Task("Pagar contas", "2024-04-03")
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(tasks.value) { index, task ->
            TaskItem(task = task)
        }
    }
}


data class Task(val name: String, val date: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        TaskListScreen()
    }
}