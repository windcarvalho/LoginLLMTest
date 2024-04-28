package org.ufc.great.llm.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginllmtest.R

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilScreen()
        }
    }

    @Composable
    fun PerfilScreen() {
        var nome by remember { mutableStateOf("Nome") }
        var sobrenome by remember { mutableStateOf("Sobrenome") }
        var email by remember { mutableStateOf("Email") }
        var telefone by remember { mutableStateOf("Telefone") }

        var fotoPerfil by remember { mutableStateOf(R.drawable.ic_launcher_background) }

        Column(modifier = Modifier.padding(16.dp)) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = fotoPerfil),
                    contentDescription = "Foto de Perfil",
                    modifier = Modifier.size(120.dp)
                )
                Button(onClick = { /* Implemente a lógica para selecionar e atualizar a foto de perfil */ }) {
                    Text(text = stringResource(id = R.string.edit))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                CampoEditavel(label = "Nome", valor = nome, onValueChanged = { nome = it })
                CampoEditavel(label = "Sobrenome", valor = sobrenome, onValueChanged = { sobrenome = it })
                CampoEditavel(label = "Email", valor = email, onValueChanged = { email = it })
                CampoEditavel(label = "Telefone", valor = telefone, keyboardType = KeyboardType.Number, onValueChanged = { telefone = it })
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Implemente a lógica para salvar as alterações */ }) {
                    Text(text = stringResource(id = R.string.salvar))
                }
            }
        }
    }

    @Composable
    fun CampoEditavel(label: String, valor: String, keyboardType: KeyboardType = KeyboardType.Text, onValueChanged: (String) -> Unit) {
        Column {
            Text(text = label, fontSize = 16.sp)
            OutlinedTextField(
                value = valor,
                onValueChange = onValueChanged,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
