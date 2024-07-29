package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cadastrollmtestgpt4.R

@Suppress("DEPRECATION")
class Tela_Compose_Access_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadastroScreen({}, {})
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CadastroScreen(onCancel: () -> Unit, onEnviar: (CadastroData) -> Unit) {
        var nome by remember { mutableStateOf("") }
        var sobrenome by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var senha by remember { mutableStateOf("") }
        var dataNascimento by remember { mutableStateOf("") }
        var genero by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
            )

            TextField(
                value = sobrenome,
                onValueChange = { sobrenome = it },
                label = { Text("Sobrenome") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            TextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                )
            )

            TextField(
                value = dataNascimento,
                onValueChange = { dataNascimento = it },
                label = { Text("Data de Nascimento") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            TextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Gênero") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onCancel) {
                    Text("Cancelar")
                }
                Button(onClick = { onEnviar(CadastroData(nome, sobrenome, email, senha, dataNascimento, genero)) }) {
                    Text("Enviar")
                }
            }
        }
    }


    data class CadastroData(
        val nome: String,
        val sobrenome: String,
        val email: String,
        val senha: String,
        val dataNascimento: String,
        val genero: String
    )

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            CadastroScreen({}, {})
        }
    }}