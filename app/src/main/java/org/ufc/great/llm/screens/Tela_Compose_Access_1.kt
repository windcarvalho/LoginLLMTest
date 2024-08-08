package org.ufc.great.llm.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.produtogpt4llmtest.R

class Tela_Compose_Access_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductDetailsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ProductDetailScreen()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductDetailScreen() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Detalhes do Produto", color = Color.White) }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .semantics { contentDescription = "Tela de detalhes do produto" }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Imagem do Produto",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .semantics { contentDescription = "Imagem ilustrativa do produto" },
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Nome do Produto",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Descrição detalhada do produto. Este texto deve fornecer informações abrangentes sobre o produto, incluindo seus principais recursos e benefícios.",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Preço: R$ 199,99",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { /*TODO: Adicionar ao carrinho*/ },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.semantics { contentDescription = "Adicionar ao Carrinho" }
                        ) {
                            Text(text = "Adicionar ao Carrinho")
                        }
                        Button(
                            onClick = { /*TODO: Adicionar aos favoritos*/ },
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                            modifier = Modifier.semantics { contentDescription = "Favoritar" }
                        ) {
                            Text(text = "Favoritar")
                        }
                    }
                }
            }
        )
    }

    @Preview
    @Composable
    fun PreviewProductDetailScreen() {
        ProductDetailScreen()
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

    val Typography = Typography (
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    val Shapes = Shapes (
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    @Composable
    fun ProductDetailsTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}