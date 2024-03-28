package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onLoginClick = {
                    // Adicione a lógica para verificar as credenciais do usuário
                },
                onForgotPasswordClick = {
                    // Adicione a lógica para lidar com o clique em "Esqueceu a senha?"
                }
            )
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun LoginScreen(
        onLoginClick: () -> Unit,
        onForgotPasswordClick: () -> Unit
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current

        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login Title",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                AccessibilityTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username or Email") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { /* Handle next action */ }
                    )
                )
                AccessibilityTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    // visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide() // Hide the keyboard when done
                        }
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onLoginClick }) {
                    Text("Login")
                }
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(onClick = onForgotPasswordClick) {
                    Text("Forgot Password?")
                }
            }
        }
    }

    @Composable
    fun AccessibilityTextField(
        value: String,
        onValueChange: (String) -> Unit,
        label: @Composable () -> Unit,
        //visualTransformation: PasswordVisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            //label = { Text(label) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            //visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLoginScreen() {
        LoginScreen(
            onLoginClick = { /* TODO */ },
            onForgotPasswordClick = { /* TODO */ }
        )
    }
}