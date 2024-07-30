package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.menulateralllmtestgpt4.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class Tela_Compose_Access_1 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val scaffoldState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = scaffoldState,
            drawerContent = {
                DrawerContent(scaffoldState, scope)
            }
        ) {
            // Seu conteúdo principal vai aqui
        }
    }

    @Composable
    fun DrawerContent(scaffoldState: DrawerState, scope: CoroutineScope) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            DrawerSection(title = "Navegação")
            DrawerItem(text = "Página Inicial", icon = R.drawable.ic_launcher_background, contentDescription = "Página Inicial")
            DrawerItem(text = "Promoções", icon = R.drawable.ic_launcher_background, contentDescription = "Promoções")
            DrawerItem(text = "Meus Pedidos", icon = R.drawable.ic_launcher_background, contentDescription = "Meus Pedidos")
            DrawerItem(text = "Meu Carrinho", icon = R.drawable.ic_launcher_background, contentDescription = "Meu Carrinho")

            Divider()

            DrawerSection(title = "Conta")
            DrawerItem(text = "Minha Conta", icon = R.drawable.ic_launcher_background, contentDescription = "Minha Conta")
            DrawerItem(text = "Sair", icon = R.drawable.ic_launcher_background, contentDescription = "Sair")
        }
    }

    @Composable
    fun DrawerSection(title: String) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

    @Composable
    fun DrawerItem(text: String, icon: Int, contentDescription: String) {
        val scaffoldState = rememberDrawerState(DrawerValue.Open)
        val scope = rememberCoroutineScope()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Handle item click
                    scope.launch {
                        scaffoldState.close()
                    }
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyAppTheme {
            MainScreen()
        }
    }


    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

    private val DarkColorPalette = darkColorScheme(
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
    fun MyAppTheme(
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
            typography = MaterialTheme.typography,
            shapes = MaterialTheme.shapes,
            content = content
        )
    }
}