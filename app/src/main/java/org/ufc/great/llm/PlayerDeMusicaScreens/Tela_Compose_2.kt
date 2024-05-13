package org.ufc.great.llm.PlayerDeMusicaScreens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Tela_Compose_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerScreen()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MusicPlayerScreen() {
        // Layout principal
        Scaffold(
            topBar = { MusicPlayerTopBar() },
            content = { MusicPlayerContent() }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MusicPlayerTopBar() {
        TopAppBar(
            title = { Text(text = "Meu Player de Música") },

        )
    }

    @Composable
    fun MusicPlayerContent() {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MusicInfo()
            Spacer(modifier = Modifier.height(16.dp))
            MusicControls()
        }
    }

    @Composable
    fun MusicInfo() {
        Text(text = "Nome da Música", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Artista - Álbum", style = MaterialTheme.typography.bodyMedium)
    }

    @Composable
    fun MusicControls() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* Ação de retroceder */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Retroceder")
            }
            IconButton(onClick = { /* Ação de reproduzir/pausar */ }) {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Reproduzir/Pausar")
            }
            IconButton(onClick = { /* Ação de avançar */ }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Avançar")
            }
        }
    }

    @Composable
    fun MusicProgressBar() {
        Slider(
            value = 0f, // Valor da posição da música
            onValueChange = { /* Ação ao alterar a posição da música */ },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun PlaylistScreen(playlist: List<String>) {
        LazyColumn {
            items(playlist) { song ->
                Text(text = song, modifier = Modifier.padding(8.dp))
            }
        }
    }



}