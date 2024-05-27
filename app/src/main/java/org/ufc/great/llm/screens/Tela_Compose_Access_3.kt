package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text
    )
}

@Composable
fun SectionHeader(text: String) {
    Text(
        text = text
    )
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
        MenuItem(text = "Página Inicial", onClick = { onMenuItemClick("Página Inicial") })
        MenuItem(text = "Promoções", onClick = { onMenuItemClick("Promoções") })
        MenuItem(text = "Meus Pedidos", onClick = { onMenuItemClick("Meus Pedidos") })
        MenuItem(text = "Meu Carrinho", onClick = { onMenuItemClick("Meu Carrinho") })

        // Divisor
        Divider()

        // Seção de conta
        SectionHeader(text = "Conta")
        MenuItem(text = "Minha Conta", onClick = { onMenuItemClick("Minha Conta") })
        MenuItem(text = "Sair", onClick = { onMenuItemClick("Sair") })
    }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainScreen()
    }
}