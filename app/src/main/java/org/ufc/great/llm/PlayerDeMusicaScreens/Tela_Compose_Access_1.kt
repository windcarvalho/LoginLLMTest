package org.ufc.great.llm.PlayerDeMusicaScreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.focusable
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

class Tela_Compose_Access_1 : ComponentActivity() {
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
                .focusable() // Permite que o layout seja focável
                .semantics {
                    // Adiciona uma descrição de acessibilidade para o layout
                    contentDescription = "Player de Música"
                }
        ) {
            // Título da Música
            Text(
                text = "Título da Música",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .focusable() // Permite que o texto seja focável
                    .semantics {
                        // Adiciona uma descrição de acessibilidade para o texto
                        contentDescription = "Título da Música: Título da Música"
                    }
            )

            // Artista
            Text(
                text = "Artista",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .focusable() // Permite que o texto seja focável
                    .semantics {
                        // Adiciona uma descrição de acessibilidade para o texto
                        contentDescription = "Artista: Artista"
                    }
            )

            // Álbum
            Text(
                text = "Álbum",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .focusable() // Permite que o texto seja focável
                    .semantics {
                        // Adiciona uma descrição de acessibilidade para o texto
                        contentDescription = "Álbum: Álbum"
                    }
            )

            // Barra de Progresso
            LinearProgressIndicator(
                progress = 0.5f, // Substitua pelo progresso real da música
                modifier = Modifier
                    .fillMaxWidth()
                    .focusable() // Permite que a barra de progresso seja focável
                    .semantics {
                        // Adiciona uma descrição de acessibilidade para a barra de progresso
                        contentDescription = "Barra de Progresso"
                    }
            )

            // Botões de Controle de Reprodução
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { /* Ação para Retroceder */ },
                    modifier = Modifier
                        .focusable() // Permite que o botão seja focável
                        .semantics {
                            // Adiciona uma descrição de acessibilidade para o botão
                            contentDescription = "Retroceder"
                        }
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Retroceder")
                }
                IconButton(
                    onClick = { /* Ação para Play/Pause */ },
                    modifier = Modifier
                        .focusable() // Permite que o botão seja focável
                        .semantics {
                            // Adiciona uma descrição de acessibilidade para o botão
                            contentDescription = "Reproduzir/Pausar"
                        }
                ) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Reproduzir/Pausar")
                }
                IconButton(
                    onClick = { /* Ação para Avançar */ },
                    modifier = Modifier
                        .focusable() // Permite que o botão seja focável
                        .semantics {
                            // Adiciona uma descrição de acessibilidade para o botão
                            contentDescription = "Avançar"
                        }
                ) {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "Avançar")
                }
            }

            // Lista de Reprodução
            Text(
                text = "Lista de Reprodução",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .focusable() // Permite que o texto seja focável
                    .semantics {
                        // Adiciona uma descrição de acessibilidade para o texto
                        contentDescription = "Lista de Reprodução"
                    }
            )
        }
    }
}