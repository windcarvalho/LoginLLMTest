package org.ufc.great.llm.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Tela_Compose_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerScreen()
        }
    }

    @Composable
    fun MusicPlayerScreen() {
        // Estado para controlar a reprodução da música
        var isPlaying by remember { mutableStateOf(false) }
        // Estado para controlar o progresso da música
        var progress by remember { mutableStateOf(0f) }

        // Composable para exibir os controles de reprodução
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botão para retroceder
            IconButton(onClick = { /* Ação de retroceder */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Retroceder"
                )
            }

            // Botão para reproduzir/pausar
            IconButton(onClick = { isPlaying = !isPlaying }) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Menu else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pausar" else "Reproduzir"
                )
            }

            // Botão para avançar
            IconButton(onClick = { /* Ação de avançar */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Avançar"
                )
            }
        }

        // Barra de progresso
        Slider(
            value = progress,
            onValueChange = { /* Ação ao alterar o progresso */ },
            valueRange = 0f..100f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        // Exibição de informações da música atual
        Text(
            text = "Nome da Música - Artista",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }

    // Composable para exibir uma entrada de música na lista de reprodução

}