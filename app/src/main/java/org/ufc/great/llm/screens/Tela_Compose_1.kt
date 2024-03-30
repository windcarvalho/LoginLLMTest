package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginllmtest.R

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailScreen(
            )
        }
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductDetailScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Detalhes do Produto") }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Aqui você incluirá os elementos da tela, como nome do produto, descrição, preço, imagem, botões de ação, etc.
                Text(text = "Nome do Produto", style = MaterialTheme.typography.displayMedium)
                Text(text = "Descrição do Produto", style = MaterialTheme.typography.displayMedium, maxLines = 3, overflow = TextOverflow.Ellipsis)
                Text(text = "$10.99", style = MaterialTheme.typography.displayMedium)
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do Produto",
                    modifier = Modifier.size(200.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = { /* Ação ao clicar no botão Adicionar ao Carrinho */ }) {
                        Text(text = "Adicionar ao Carrinho")
                    }
                    Button(onClick = { /* Ação ao clicar no botão Favoritos */ }) {
                        Text(text = "Favoritos")
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewProductDetailScreen() {
        ProductDetailScreen()
    }

}