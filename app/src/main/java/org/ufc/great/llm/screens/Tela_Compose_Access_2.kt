package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.menulateralllmtest.R
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class Tela_Compose_Access_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyApp() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }

        val closeDrawer = {
            scope.launch {
                drawerState.close()
            }
        }

        val launcher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            // Handle the result of the document picker
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("App") },
                    navigationIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Abrir Menu"
                        )
                    }
                )
            },
            content = {
                Drawer(drawerState = drawerState) { menuItem ->
                    // Handle menu item click here
                    when (menuItem) {
                        "Página Inicial" -> { /* Implement your logic here */ }
                        "Promoções" -> { /* Implement your logic here */ }
                        "Meus Pedidos" -> { /* Implement your logic here */ }
                        "Meu Carrinho" -> { /* Implement your logic here */ }
                        "Minha Conta" -> { /* Implement your logic here */ }
                        "Sair" -> { /* Implement your logic here */ }
                    }
                    closeDrawer()
                }
            }
        )
    }

    @Composable
    fun Drawer(
        drawerState: DrawerState,
        onMenuItemClick: (String) -> Unit
    ) {
        val xOffset by animateFloatAsState(
            targetValue = if (drawerState.isOpen) 0f else (-300).toFloat(),
            animationSpec = spring()
        )

        val backgroundColor = MaterialTheme.colorScheme.surface

        Surface(
            modifier = Modifier
                .offset(x = Dp(xOffset))
                .fillMaxSize(),
            color = backgroundColor,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text("Menu")

                Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth())

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        MenuItem(text = "Página Inicial", onClick = { onMenuItemClick("Página Inicial") })
                        MenuItem(text = "Promoções", onClick = { onMenuItemClick("Promoções") })
                        MenuItem(text = "Meus Pedidos", onClick = { onMenuItemClick("Meus Pedidos") })
                        MenuItem(text = "Meu Carrinho", onClick = { onMenuItemClick("Meu Carrinho") })

                        Divider(color = Color.LightGray, modifier = Modifier.fillMaxWidth())

                        MenuItem(text = "Minha Conta", onClick = { onMenuItemClick("Minha Conta") })
                        MenuItem(text = "Sair", onClick = { onMenuItemClick("Sair") })
                    }
                }
            }
        }
    }

    @Composable
    private fun MenuItem(
        text: String,
        onClick: () -> Unit
    ) {
        Text(
            text = text
        )
    }

    @Preview
    @Composable
    fun PreviewCadastroScreen() {
        MyApp()
    }
}