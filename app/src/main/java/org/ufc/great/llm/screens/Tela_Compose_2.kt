package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.menulateralllmtestgpt4.R
import kotlinx.coroutines.launch

class Tela_Compose_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {
        val scaffoldState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Application") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = {
                // Seu conteúdo principal aqui
                DrawerContent()
            }
        )
    }

    @Composable
    fun DrawerContent() {
        Column {
            // Primeira Seção
            Text("Navegação", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(16.dp))
            Divider()
            DrawerItem("Página Inicial")
            DrawerItem("Promoções")
            DrawerItem("Meus Pedidos")
            DrawerItem("Meu Carrinho")
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            // Segunda Seção
            Text("Conta", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(16.dp))
            DrawerItem("Minha Conta")
            DrawerItem("Sair")
        }
    }

    @Composable
    fun DrawerItem(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    // Ação ao clicar no item do menu
                }
        )
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
        secondary = Color(0xFF03DAC5)
    )

    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC5)
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

//COLAR