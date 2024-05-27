package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Tela_Compose_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun Drawer(
        onMenuItemClick: (String) -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            // Seção de navegação
            SectionHeader(text = "Navegação")
            MenuItem(text = "Página Inicial", onItemClick = { onMenuItemClick("Página Inicial") })
            MenuItem(text = "Promoções", onItemClick = { onMenuItemClick("Promoções") })
            MenuItem(text = "Meus Pedidos", onItemClick = { onMenuItemClick("Meus Pedidos") })
            MenuItem(text = "Meu Carrinho", onItemClick = { onMenuItemClick("Meu Carrinho") })

            // Divisor
            Divider()

            // Seção de conta
            SectionHeader(text = "Conta")
            MenuItem(text = "Minha Conta", onItemClick = { onMenuItemClick("Minha Conta") })
            MenuItem(text = "Sair", onItemClick = { onMenuItemClick("Sair") })
        }
    }

    @Composable
    fun SectionHeader(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainScreen() {
        var selectedItem by remember { mutableStateOf("") }

        Scaffold(
            content = {
                // Conteúdo principal da tela
                // Aqui você colocaria o conteúdo da tela principal da sua aplicação
                Text("Conteúdo principal da tela: $selectedItem")
                Drawer(onMenuItemClick = { selectedItem = it })
            }
        )
    }

    @Composable
    fun MenuItem(
        text: String,
        onItemClick: () -> Unit
    ) {
        Text(
            text = text,
            modifier = Modifier
                .clickable { onItemClick() }
                .padding(16.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            MainScreen()
        }
    }
}