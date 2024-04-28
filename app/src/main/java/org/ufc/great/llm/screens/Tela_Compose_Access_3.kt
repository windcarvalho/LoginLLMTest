package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import com.example.loginllmtest.R

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun MyApp(content: @Composable () -> Unit) {

    }

    @Composable
    fun ProfileScreen() {
        // Exemplo de estado para foto de perfil
        val profilePicture = painterResource(id = R.drawable.ic_launcher_background)
        // Exemplo de estado para informações do perfil
        val nameState = remember { mutableStateOf("John") }
        val lastNameState = remember { mutableStateOf("Doe") }
        val emailState = remember { mutableStateOf("john.doe@example.com") }
        val phoneState = remember { mutableStateOf("123456789") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = profilePicture,
                contentDescription = "Profile Picture",
                modifier = Modifier.size(120.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                label = { Text(text = "Name") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = lastNameState.value,
                onValueChange = { lastNameState.value = it },
                label = { Text(text = "Last Name") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text(text = "Email") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = phoneState.value,
                onValueChange = { phoneState.value = it },
                label = { Text(text = "Phone") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /*TODO: Salvar alterações*/ }) {
                Text(text = "Salvar")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp {
            ProfileScreen()
        }
    }
}