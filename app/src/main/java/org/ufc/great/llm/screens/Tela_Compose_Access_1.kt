package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
//import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Suppress("DEPRECATION")
class Tela_Compose_Access_1 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @ExperimentalMaterial3Api
    @Composable
    fun App() {
        var isMenuOpen by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "App") },
                    navigationIcon = {
                        IconButton(
                            onClick = { isMenuOpen = true },
                            content = {
                                Icon(Icons.Filled.Menu, contentDescription = "Abrir menu")
                            }
                        )
                    }
                )
            },
            content = {
                SideMenu(
                    isOpen = isMenuOpen,
                    onClose = { isMenuOpen = false },
                    onItemClick = {
                        // Lidar com os cliques nos itens do menu aqui
                        when (it) {
                            "Página Inicial" -> { /* Navegar para a página inicial */ }
                            "Promoções" -> { /* Navegar para a página de promoções */ }
                            "Meus Pedidos" -> { /* Navegar para a página de pedidos */ }
                            "Meu Carrinho" -> { /* Navegar para o carrinho */ }
                            "Minha Conta" -> { /* Navegar para a página da conta */ }
                            "Sair" -> { /* Implementar a lógica para sair da conta */ }
                        }
                        isMenuOpen = false
                    }
                )
            }
        )
    }

    @Composable
    fun SideMenu(
        isOpen: Boolean,
        onClose: () -> Unit,
        onItemClick: (String) -> Unit
    ) {
        val items = listOf(
            "Página Inicial",
            "Promoções",
            "Meus Pedidos",
            "Meu Carrinho",
            "Minha Conta",
            "Sair"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .width(250.dp)
                .offset { IntOffset(if (isOpen) 0 else -250, 0) }
        ) {
            items.forEach { item ->
                MenuItem(
                    isOpen = isOpen,
                    text = item,
                    onClick = { onItemClick(item) }
                )
            }
        }
    }

    @Composable
    fun MenuItem(
        isOpen: Boolean,
        text: String,
        onClick: () -> Unit
    ) {
        val focusRequester = remember { FocusRequester() }

        TextButton(
            onClick = onClick,
            modifier = Modifier
                .padding(8.dp)
                .focusRequester(focusRequester)
                .onGloballyPositioned { coordinates ->
                    if (text == "Página Inicial" && coordinates != null && isOpen) {
                        focusRequester.requestFocus()
                    }
                }
        ) {
            Text(text = text)
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            App()
        }
    }}