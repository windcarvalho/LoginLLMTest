package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login", style = MaterialTheme.typography.titleSmall)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = {
                username = it
                isError = false
            },
            label = { Text("Username/Email") },
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(text = "Campo obrigatório", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
                isError = false
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )

        if (isError) {
            Text(text = "Campo obrigatório", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isEmpty() || password.isEmpty()) {
                    isError = true
                } else {
                    // Handle login
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = { /* Handle forgot password */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Esqueceu a senha?")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginAppTheme {
        LoginScreen()
    }
}

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onSurfaceVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC5),
    background = Color.Black,
    surface = Color.DarkGray,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE),
    onSurfaceVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC5),
    background = Color.White,
    surface = Color.LightGray,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val Typography = Typography (
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

@Composable
fun LoginAppTheme(
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