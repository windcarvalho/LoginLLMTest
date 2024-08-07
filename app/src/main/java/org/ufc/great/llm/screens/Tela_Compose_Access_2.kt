package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Suppress("DEPRECATION")
class Tela_Compose_Access_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen() {
        val scaffoldState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Application") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    scaffoldState.open()
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = null) // O contentDescription já está no IconButton
                        }
                    }
                )
            },
            content = {
                DrawerContent()
            }
        )
    }

    @Composable
    fun DrawerContent() {
        Column {
            Text("Navegação", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(16.dp))
            Divider()
            DrawerItem("Página Inicial")
            DrawerItem("Promoções")
            DrawerItem("Meus Pedidos")
            DrawerItem("Meu Carrinho")
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text("Conta", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(16.dp))
            DrawerItem("Minha Conta")
            DrawerItem("Sair")
        }
    }

    @Composable
    fun DrawerItem(text: String) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = MaterialTheme.shapes.small,
            shadowElevation = 4.dp
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(
                        onClickLabel = "Navigate to $text"
                    ) {
                        // Ação ao clicar no item do menu
                    }
                    .focusable()
            )
        }
    }



    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        MaterialTheme {
            MainScreen()
        }
    }

    private val DarkColorPalette = darkColorScheme(
        primary = Color(0xFFBB86FC),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC5),
        onPrimary = Color.Black,
        onSecondary = Color.Black
    )

    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC5),
        onPrimary = Color.White,
        onSecondary = Color.Black
    )

    val Typography = Typography(
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    val Shapes = Shapes (
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

//    @Composable
//    fun MyAppTheme(
//        darkTheme: Boolean = isSystemInDarkTheme(),
//        content: @Composable () -> Unit
//    ) {
//        val colors = if (darkTheme) {
//            DarkColorPalette
//        } else {
//            LightColorPalette
//        }
//
//        MaterialTheme(
//            colorScheme = colors,
//            typography = Typography,
//            shapes = Shapes,
//            content = content
//        )
//    }
}