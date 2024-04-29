package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
            CadastroScreen()
        }
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CadastroScreen() {
        var nome by remember { mutableStateOf("") }
        var sobrenome by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var senha by remember { mutableStateOf("") }
        var dataNascimento by remember { mutableStateOf("") }
        var genero by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Cadastro") },
                    colors = TopAppBarDefaults.topAppBarColors()
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = nome,
                        onValueChange = { nome = it },
                        label = { Text("Nome") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    TextField(
                        value = sobrenome,
                        onValueChange = { sobrenome = it },
                        label = { Text("Sobrenome") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("E-mail") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    TextField(
                        value = senha,
                        onValueChange = { senha = it },
                        label = { Text("Senha") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    TextField(
                        value = dataNascimento,
                        onValueChange = { dataNascimento = it },
                        label = { Text("Data de Nascimento") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    TextField(
                        value = genero,
                        onValueChange = { genero = it },
                        label = { Text("Gênero") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = TextFieldDefaults.textFieldColors()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = { /* implementar a lógica de envio */ },
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            Text("Enviar")
                        }
                        Button(
                            onClick = { /* implementar a lógica de cancelamento */ },
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            Text("Cancelar")
                        }
                    }
                }
            }
        )
    }

    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        CadastroScreen()
    }


}