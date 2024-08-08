package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.produtogpt4llmtest.R

class Tela_Compose_Access_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailScreen("Nome do produto", "Descrição do produto", "99,99"
            )
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ProductDetailScreen(productName: String, productDescription: String, productPrice: String) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = R.string.product_name)) }
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
                Text(
                    text = productName,
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = productDescription,
                    style = MaterialTheme.typography.displayMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = productPrice,
                    style = MaterialTheme.typography.displayMedium
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do Produto: $productName",
                    modifier = Modifier
                        .size(200.dp)
                        .semantics {
                            contentDescription = "Imagem do Produto: $productName"
                        }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { /* Ação ao clicar no botão Adicionar ao Carrinho */ }
                    ) {
                        Text(text = stringResource(id = R.string.add_to_cart))
                    }
                    Button(
                        onClick = { /* Ação ao clicar no botão Favoritos */ }
                    ) {
                        Text(text = stringResource(id = R.string.add_to_favorites))
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewProductDetailScreen() {
        ProductDetailScreen(
            productName = "Nome do Produto",
            productDescription = "Descrição do Produto",
            productPrice = "$10.99"
        )
    }}