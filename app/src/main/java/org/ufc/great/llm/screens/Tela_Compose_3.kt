package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.produtollmtest.R

class Tela_Compose_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailScreen("Nome do produto","Descrição do produto","99,99", R.drawable.ic_launcher_background,/*""*/
            )
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ProductDetailScreen(
        productName: String,
        productDescription: String,
        productPrice: String,
        productImageRes: Int,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = productName) },
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = productImageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = productDescription,
                        style = MaterialTheme.typography.displayMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Preço: $productPrice",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {  }) {
                            Text("Adicionar ao Carrinho")
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Button(onClick = {  }) {
                            Text("Favoritos")
                        }
                    }
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewProductDetailScreen() {
        ProductDetailScreen(
            productName = "Nome do Produto",
            productDescription = "Descrição do Produto",
            productPrice = "$9.99",
            productImageRes = R.drawable.ic_launcher_background,
        )
    }
}