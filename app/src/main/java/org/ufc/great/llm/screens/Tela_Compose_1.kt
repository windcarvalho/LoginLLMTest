package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                App()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun App() {
        var isMenuOpen by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "App") },
                    navigationIcon = {
                        IconButton(onClick = { isMenuOpen = true }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = {
                SideMenu(
                    isOpen = isMenuOpen,
                    onClose = { isMenuOpen = false },
                    onItemClick = {
                        // Handle menu item clicks here
                        when (it) {
                            "Página Inicial" -> { /* Navegar para a página inicial */ }
                            "Promoções" -> { /* Navegar para a página de promoções */ }
                            "Meus Pedidos" -> { /* Navegar para a página de pedidos */ }
                            "Meu Carrinho" -> { /* Navegar para o carrinho */ }
                            "Minha Conta" -> { /* Navegar para a página da conta */ }
                            "Sair" -> { /* Implemente a lógica para sair da conta */ }
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
        val items = listOf("Página Inicial", "Promoções", "Meus Pedidos", "Meu Carrinho")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .width(250.dp)
                .offset { IntOffset(if (isOpen) 0 else -250, 0) }
        ) {
            items.forEach { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onItemClick(item) }
                )
            }
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = "Minha Conta",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemClick("Minha Conta") }
            )
            Text(
                text = "Sair",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemClick("Sair") }
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            App()
        }
    }

}