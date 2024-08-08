package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.produtogpt4llmtest.R

class Tela_Compose_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailsTheme {
                // Chama a tela de detalhes do produto
                ProductDetailScreen(
                    productName = "Nome do Produto",
                    productDescription = "Esta é uma descrição detalhada do produto. Ela deve ser informativa e envolvente, fornecendo todas as informações necessárias sobre o produto.",
                    productPrice = "R$ 199,99",
                    productImage = "https://via.placeholder.com/150"
                )
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductDetailScreen(
        productName: String,
        productDescription: String,
        productPrice: String,
        productImage: String
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Detalhes do Produto") },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(productImage),
                        contentDescription = "Imagem do Produto",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = productName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = productDescription,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = productPrice,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Green
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /* Ação para adicionar ao carrinho */ },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Adicionar ao Carrinho")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /* Ação para adicionar aos favoritos */ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                        ) {
                            Text("Adicionar aos Favoritos")
                        }
                    }
                }
            }
        )
    }

    @Preview
    @Composable
    fun PreviewProductDetailScreen() {
        ProductDetailsTheme {
            // Chama a tela de detalhes do produto
            ProductDetailScreen(
                productName = "Nome do Produto",
                productDescription = "Esta é uma descrição detalhada do produto. Ela deve ser informativa e envolvente, fornecendo todas as informações necessárias sobre o produto.",
                productPrice = "R$ 199,99",
                productImage = "https://via.placeholder.com/150"
            )
        }
    }

    private val DarkColorPalette = darkColorScheme(
        primary = Color(0xFF1EB980),
        onSurfaceVariant = Color(0xFF045D56),
        secondary = Color(0xFF03DAC5)
    )

    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6)
    )

    val Typography = Typography(
        bodySmall = androidx.compose.ui.text.TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    @Composable
    fun ProductDetailsTheme(content: @Composable () -> Unit) {
        val colors = LightColorPalette

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

//COLAR