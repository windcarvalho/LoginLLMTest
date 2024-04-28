package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginllmtest.R


class Tela_Compose_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilScreen(

            )
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PerfilScreen() {
        var nome by remember { mutableStateOf("João") }
        var sobrenome by remember { mutableStateOf("Silva") }
        var email by remember { mutableStateOf("joao.silva@example.com") }
        var telefone by remember { mutableStateOf("123456789") }
        var fotoPerfil by remember { mutableStateOf(R.drawable.ic_launcher_background) } // Defina uma imagem padrão

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Perfil") },
                    actions = {}
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = fotoPerfil),
                        contentDescription = "Foto de Perfil",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedButton(onClick = { /* Ação de editar foto */ }) {
                        Text(text = "Editar Foto", fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = nome,
                        onValueChange = { nome = it },
                        label = { Text("Nome") }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = sobrenome,
                        onValueChange = { sobrenome = it },
                        label = { Text("Sobrenome") }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("E-mail") }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = telefone,
                        onValueChange = { telefone = it },
                        label = { Text("Telefone") }
                    )
                }
            }
        )
    }

    @Preview
    @Composable
    fun PreviewPerfilScreen() {
        PerfilScreen()
    }
}

//COLAR