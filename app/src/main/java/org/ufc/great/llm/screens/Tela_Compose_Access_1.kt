package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Suppress("DEPRECATION")
class Tela_Compose_Access_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistrationFormTheme {
                RegisterScreen()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegisterScreen() {
        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var birthDate by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cadastro") }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("Nome") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para nome" },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Sobrenome") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para sobrenome" },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Endereço de E-mail") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para endereço de e-mail" },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Senha") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para senha" },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = birthDate,
                        onValueChange = { birthDate = it },
                        label = { Text("Data de Nascimento") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para data de nascimento" },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = gender,
                        onValueChange = { gender = it },
                        label = { Text("Gênero") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .semantics { contentDescription = "Campo para gênero" },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /* Handle Cancel */ },
                            modifier = Modifier.semantics {
                                contentDescription = "Botão Cancelar"
                            }
                        ) {
                            Text("Cancelar")
                        }
                        Button(
                            onClick = { /* Handle Submit */ },
                            modifier = Modifier.semantics {
                                contentDescription = "Botão Enviar"
                            }
                        ) {
                            Text("Enviar")
                        }
                    }
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        RegistrationFormTheme {
            RegisterScreen()
        }
    }
    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

    private val DarkColorPalette = darkColorScheme (
        primary = Purple200,
        onSurfaceVariant = Purple700,
        secondary = Teal200
    )

    private val LightColorPalette = lightColorScheme(
        primary = Purple500,
        onSurfaceVariant = Purple700,
        secondary = Teal200
    )

    @Composable
    fun RegistrationFormTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = MaterialTheme.shapes,
            content = content
        )
    }

    val Typography = Typography(
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
}