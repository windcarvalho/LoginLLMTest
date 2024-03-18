package com.example.loginllmtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ufc.great.llm.screens.*

class MainActivity : ComponentActivity() {
    // Lista de pares contendo o nome do item e a classe da Activity correspondente
    private val itemsList = listOf(
        "Login Padrão 1" to Tela_Login1::class.java,
        "Login Padrão 2" to Tela_Login2::class.java,
        "Login Padrão 3" to Tela_Login3::class.java,
        // Adicione os demais nomes e Activities aqui
        "Login Cons_Layout 1 " to Tela_Login_CL_1::class.java,
        "Login Cons_Layout 2 " to Tela_Login_CL_2::class.java,
        "Login Cons_Layout 3 " to Tela_Login_CL_3::class.java,

        "Login Compose 1 " to Tela_Login_Compose_1::class.java,
        "Login Compose 2 " to Tela_Login_Compose_2::class.java,
        "Login Compose 2 " to Tela_Login_Compose_3::class.java,

        "Login Padrão 1 Acessível" to Tela_Login_Access_1::class.java,
        "Login Padrão 2 Acessível" to Tela_Login_Access_2::class.java,
        "Login Padrão 3 Acessível" to Tela_Login_Access_3::class.java,
        // Adicione os demais nomes e Activities aqui
        "Login Cons_Layout 1 Acessível " to Tela_Login_CL_Access_1::class.java,
        "Login Cons_Layout 2 Acessível " to Tela_Login_CL_Access_2::class.java,
        "Login Cons_Layout 3 Acessível" to Tela_Login_CL_Access_3::class.java,
        "Login Compose 1 Acessível" to Tela_Login_Compose_Access_1::class.java,
        "Login Compose 2 Acessível" to Tela_Login_Compose_Access_2::class.java,
        "Login Compose 2 Acessível" to Tela_Login_Compose_Access_3::class.java
        // Certifique-se de que as Activities estão corretamente importadas
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val barrasup = Color(0xFF2C2966)
        val barrasep = Color(0xFF131047)
        setContent {
             // Título
                Column {
                    Text(
                        text = "Testes com Chat  GPT 3.5",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth() // Faz o Text ocupar a largura máxima do container pai
                            .background(barrasup)
                            .padding(top = 30.dp),
                        textAlign = TextAlign.Center // Centraliza o texto horizontalmente
                    )
                    // Texto pequeno
                    Text(
                        text = "Interfaces geradas em Março/24. Clique na lista para ativá-las",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(barrasup)
                            .padding(top = 10.dp)
                            .padding(bottom = 30.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(barrasep)
                            .padding(top = 10.dp)
                            .padding(bottom = 20.dp),
                        textAlign = TextAlign.Center
                    )
                    //Lista de Itens
                    LazyColumnScreen(itemsList) { activityClass ->
                    val intent = android.content.Intent(applicationContext, activityClass)
                    startActivity(intent)
                }
                }

        }
    }
}






@Composable
fun LazyColumnScreen(items: List<Pair<String, Class<*>>>, onItemClick: (Class<*>) -> Unit) {
    val primaryBlue = Color(0xFF6C6C94)
    LazyColumn {
        items(items) { item ->
            Text(
                text = item.first, // Mostra o nome único
                fontWeight = FontWeight.Bold,
                color = primaryBlue,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .clickable { onItemClick(item.second) } // Passa a classe da Activity quando o item é clicado
                    .padding(16.dp),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
    }
}


