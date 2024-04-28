package org.ufc.great.llm.screens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginllmtest.R

class Tela_Compose_Access_1 : ComponentActivity() {
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
                    painterResource(fotoPerfil),
                    contentDescription = stringResource(id = R.string.profile_image_description),
                    modifier = Modifier.size(120.dp)
                )
                Button(onClick = { /* Implemente a lógica para selecionar e atualizar a foto de perfil */ }) {
                    Text(text = stringResource(id = R.string.edit))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            ScrollableColumn {
                CampoEditavel(label = stringResource(id = R.string.first_name), valor = nome, onValueChanged = { nome = it })
                CampoEditavel(label = stringResource(id = R.string.last_name), valor = sobrenome, onValueChanged = { sobrenome = it })
                CampoEditavel(label = stringResource(id = R.string.email), valor = email, onValueChanged = { email = it })
                CampoEditavel(label = stringResource(id = R.string.phone), valor = telefone, keyboardType = KeyboardType.Number, onValueChanged = { telefone = it })
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Implemente a lógica para salvar as alterações */ }) {
                    Text(text = stringResource(id = R.string.salvar))
                }
            }
        }
    }

    @Composable
    fun ScrollableColumn(content: @Composable () -> Unit) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            content()
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
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = label) }, // Adicionando rótulo descritivo para acessibilidade
                placeholder = { Text(text = label) }, // Adicionando texto de placeholder para acessibilidade
                singleLine = true // Define se o campo de texto deve ser de apenas uma linha
            )
        }
    }
}
