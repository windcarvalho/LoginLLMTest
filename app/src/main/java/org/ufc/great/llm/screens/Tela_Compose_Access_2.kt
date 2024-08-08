package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.sp
import com.example.produtogpt4llmtest.R

class Tela_Compose_Access_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailsScreen(
            )
        }
    }

    @Composable
    fun ProductDetailsScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Product Image
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Visualização do produto: Nome do Produto",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Product Name
            Text(
                text = "Product Name",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Nome do Produto"
                    }
            )

            // Product Description
            Text(
                text = "Product Description",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Descrição do Produto"
                    }
            )

            // Product Price
            Text(
                text = "$99.99",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .semantics {
                        contentDescription = "Preço: $99.99"
                    }
            )

            // Add to Cart Button
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp),
                content = {
                    Text(
                        text = "Adicionar ao Carrinho",
                        modifier = Modifier
                            .semantics {
                                contentDescription = "Adicionar ao Carrinho"
                            }
                    )
                }
            )

            // Add to Favorites Button
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 16.dp),
                content = {
                    Text(
                        text = "Adicionar aos Favoritos",
                        modifier = Modifier
                            .semantics {
                                contentDescription = "Adicionar aos Favoritos"
                            }
                    )
                }
            )
        }
    }


}