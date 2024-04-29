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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cadastrollmtest.R

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CadastroScreen(
                    onCancel = { /* Implementar ação de cancelar */ },
                    onEnviar = { cadastroData -> /* Implementar ação de enviar dados */ }
                )
            }
        }
    }

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = sobrenome,
                onValueChange = { sobrenome = it },
                label = { Text("Sobrenome") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = dataNascimento,
                onValueChange = { dataNascimento = it },
                label = { Text("Data de Nascimento") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Gênero") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = onCancel) {
                    Text("Cancelar")
                }
                Spacer(modifier = Modifier.width(16.dp))
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
    }

}