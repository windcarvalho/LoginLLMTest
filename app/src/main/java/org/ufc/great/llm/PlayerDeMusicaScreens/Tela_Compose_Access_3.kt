package org.ufc.great.llm.PlayerDeMusicaScreens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerScreen()
        }
    }

    @Composable
    fun MusicPlayerScreen() {
        var isPlaying by remember { mutableStateOf(false) }
        var progress by remember { mutableStateOf(0f) }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Ação de retroceder */ },
                    content = {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retroceder"
                        )
                    }
                )

                IconButton(
                    onClick = { isPlaying = !isPlaying },
                    content = {
                        Icon(
                            imageVector = if (isPlaying) Icons.Default.Menu else Icons.Default.PlayArrow,
                            contentDescription = if (isPlaying) "Pausar" else "Reproduzir"
                        )
                    }
                )

                IconButton(
                    onClick = { /* Ação de avançar */ },
                    content = {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Avançar"
                        )
                    }
                )
            }

            Slider(
                value = progress,
                onValueChange = { /* Ação ao alterar o progresso */ },
                valueRange = 0f..100f,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Nome da Música - Artista",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}