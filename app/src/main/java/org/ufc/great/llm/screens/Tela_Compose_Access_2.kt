package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

class Tela_Compose_Access_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ProfileScreen()
                }
            }
        }
    }

    @Composable
    fun ProfileScreen() {
        var isEditing by remember { mutableStateOf(false) }
        var profileImage by remember { mutableStateOf("https://via.placeholder.com/150") }
        var name by remember { mutableStateOf(TextFieldValue("John Doe")) }
        var surname by remember { mutableStateOf(TextFieldValue("Doe")) }
        var email by remember { mutableStateOf(TextFieldValue("johndoe@example.com")) }
        var phone by remember { mutableStateOf(TextFieldValue("123-456-7890")) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ProfileImage(profileImage) {
                // Código para atualizar a imagem de perfil
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (isEditing) {
                EditableProfileField("Nome", name) { name = it }
                EditableProfileField("Sobrenome", surname) { surname = it }
                EditableProfileField("E-mail", email) { email = it }
                EditableProfileField("Telefone", phone) { phone = it }
            } else {
                ProfileField("Nome", name.text)
                ProfileField("Sobrenome", surname.text)
                ProfileField("E-mail", email.text)
                ProfileField("Telefone", phone.text)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    isEditing = !isEditing
                    // Adicionar lógica para salvar alterações quando isEditing for false
                },
                modifier = Modifier
                    .semantics {
                        contentDescription = if (isEditing) "Salvar alterações" else "Editar perfil"
                    }
            ) {
                Text(if (isEditing) "Salvar" else "Editar")
            }
        }
    }

    @Composable
    fun ProfileImage(profileImageUrl: String, onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray, shape = CircleShape)
                .clickable(onClick = onClick)
                .semantics { contentDescription = "Imagem de perfil, clique para mudar" },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(profileImageUrl),
                contentDescription = "Imagem de perfil",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
        }
    }

    @Composable
    fun ProfileField(label: String, value: String) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(label, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
            Text(value, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface)
        }
    }

    @Composable
    fun EditableProfileField(label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(label, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics { contentDescription = "Campo de $label" }
            )
        }
    }


    private val DarkColorPalette = darkColorScheme(
        primary = Color(0xFF1EB980),
        onSurfaceVariant = Color(0xFF045D56),
        secondary = Color(0xFF03DAC5)
    )

    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6)
    )

    val Typography = Typography(
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    @Composable
    fun ProfileAppTheme(
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
            shapes = Shapes,
            content = content
        )
    }

}