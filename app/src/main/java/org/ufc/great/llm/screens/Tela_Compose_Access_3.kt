package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationFormTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RegistrationScreen()
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para o primeiro nome" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Sobrenome") },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para o sobrenome" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Endereço de E-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para o endereço de e-mail" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para a senha" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = { Text("Data de Nascimento") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para a data de nascimento" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gênero") },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Campo para o gênero" }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(8.dp)
                    .semantics { contentDescription = "Mensagem de erro" }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    // Handle send action
                    // Add validation logic here
                    if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank() || birthDate.isBlank() || gender.isBlank()) {
                        errorMessage = "Todos os campos devem ser preenchidos"
                    } else {
                        errorMessage = ""
                        // Proceed with the registration
                    }
                },
                modifier = Modifier.semantics { contentDescription = "Botão Enviar" }
            ) {
                Text("Enviar")
            }
            Button(
                onClick = { /* Handle cancel action */ },
                modifier = Modifier.semantics { contentDescription = "Botão Cancelar" }
            ) {
                Text("Cancelar")
            }
        }
    }
}

@Composable
fun RegistrationFormTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        // Add your custom colors, typography, and shapes here
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}