package com.example.loginllmtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ufc.great.llm.screens.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    // Lista de pares contendo o nome do item e a classe da Activity correspondente
    private val itemsList = listOf(
        "Padrão 1" to Tela_Login1::class.java,
        "Padrão 2" to Tela_Login2::class.java,
        "Padrão 3" to Tela_Login3::class.java,

        //Telas com pedido de acessibilidade
        "Padrão 1 Acessível" to Tela_Login_Access_1::class.java,
        "Padrão 2 Acessível" to Tela_Login_Access_2::class.java,
        "Padrão 3 Acessível" to Tela_Login_Access_3::class.java,

        //Telas com pedido para Constraint Layout
        "Constraint_Layout 1 " to Tela_Login_CL_1::class.java,
        "Constraint_Layout 2 " to Tela_Login_CL_2::class.java,
        "Constraint_Layout 3 " to Tela_Login_CL_3::class.java,

        "Constraint_Layout 1 Acessível " to Tela_Login_CL_Access_1::class.java,
        "Constraint_Layout 2 Acessível " to Tela_Login_CL_Access_2::class.java,
        "Constraint_Layout 3 Acessível" to Tela_Login_CL_Access_3::class.java,

        //Telas com pedido para Compose
        "Compose 1 " to Tela_Login_Compose_1::class.java,
        "Compose 2 " to Tela_Login_Compose_2::class.java,
        "Compose 2 " to Tela_Login_Compose_3::class.java,

        "Compose 1 Acessível" to Tela_Login_Compose_Access_1::class.java,
        "Compose 2 Acessível" to Tela_Login_Compose_Access_2::class.java,
        "Compose 2 Acessível" to Tela_Login_Compose_Access_3::class.java

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val barrasup = Color(0xFF2C2966)
        val barrasep = Color(0xFF131047)
        setContent {
             // Título
                Column {
                    Text(
                        text = "Telas de LOGIN com ChatGPT 3.5",
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
                        text = "Interfaces geradas em Março/24",
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
                        text = "Clique nos itens da lista para ativá-las",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = barrasep,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
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
fun SwitchMinimalExample() {
    var checked by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        } ,
        modifier = Modifier
            .background(White)
            .offset(x = -20.dp)
    )
}

@Composable
private fun CharacterHeader(initial: Char) = Unit

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnScreen(items: List<Pair<String, Class<*>>>, onItemClick: (Class<*>) -> Unit) {
    val primaryBlue = Color(0xFF6C6C94)
    val grouped = items.groupBy { it.first.subSequence(0,it.first.indexOf(' ')) }
    val barrasep = Color(0xFF6661C0)
   LazyColumn {
        grouped.forEach { (initial,items) ->
            stickyHeader {
                //CharacterHeader(initial.get(0))
                Text(
                    "Seção "+initial,
                    Modifier
                        .fillMaxWidth()
                        .background(barrasep)
                        .padding(8.dp),
                    fontWeight = FontWeight.ExtraBold,
                    color = White
                )
            }

            items(items) { item ->
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.first, // Mostra o nome único
                        fontWeight = FontWeight.Bold,
                        color = primaryBlue,
                        modifier = Modifier
                            .background(White)
                            .weight(1f)
                            .clickable { onItemClick(item.second) } // Passa a classe da Activity quando o item é clicado
                            .padding(16.dp),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                    SwitchMinimalExample(

                    )
                }
            }
        }
    }
}


