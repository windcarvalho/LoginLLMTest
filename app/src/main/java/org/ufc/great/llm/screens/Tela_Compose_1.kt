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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.menulateralllmtestgpt4.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Tela_Compose_1 : ComponentActivity() {
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
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(drawerState, scope)
            }
        ) {
            // Your main content goes here
        }
    }

    @Composable
    fun DrawerContent(drawerState: DrawerState, scope: CoroutineScope) {
        Column {
            DrawerSection("Navegação")
            DrawerItem("Página Inicial", R.drawable.ic_launcher_background)
            DrawerItem("Promoções", R.drawable.ic_launcher_background)
            DrawerItem("Meus Pedidos", R.drawable.ic_launcher_background)
            DrawerItem("Meu Carrinho", R.drawable.ic_launcher_background)

            Divider()

            DrawerSection("Conta")
            DrawerItem("Minha Conta", R.drawable.ic_launcher_background)
            DrawerItem("Sair", R.drawable.ic_launcher_background)
        }
    }

    @Composable
    fun DrawerSection(title: String) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(16.dp)
        )
    }

    @Composable
    fun DrawerItem(text: String, icon: Int) {
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
            Icon(painter = painterResource(id = icon), contentDescription = null)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, style = MaterialTheme.typography.bodySmall)
        }
    }

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