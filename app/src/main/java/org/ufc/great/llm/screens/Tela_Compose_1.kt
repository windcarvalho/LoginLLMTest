package org.ufc.great.llm.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayer()
        }
    }

    @Composable
    fun MusicPlayer() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Título da Música
            Text(
                text = "Título da Música",
                style = MaterialTheme.typography.bodyMedium
            )

            // Artista
            Text(
                text = "Artista",
                style = MaterialTheme.typography.bodyMedium
            )

            // Álbum
            Text(
                text = "Álbum",
                style = MaterialTheme.typography.bodyMedium
            )

            // Barra de Progresso
            LinearProgressIndicator(
                progress = 0.5f, // Substitua pelo progresso real da música
                modifier = Modifier.fillMaxWidth()
            )

            // Botões de Controle de Reprodução
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /* Ação para Retroceder */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Retroceder")
                }
                IconButton(onClick = { /* Ação para Play/Pause */ }) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Reproduzir")
                }
                IconButton(onClick = { /* Ação para Avançar */ }) {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "Avançar")
                }
            }

            // Lista de Reprodução
            Text(
                text = "Lista de Reprodução",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

}