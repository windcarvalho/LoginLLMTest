package org.ufc.great.llm.screens

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.musicagpt4llmtest.R

class Tela_Compose_1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicPlayerScreen()
                }
            }
        }
    }

    @Composable
    fun MusicPlayerScreen() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                MusicInfo()
                MusicControls()
                Playlist()
            }
        }
    }

    @Composable
    fun MusicControls() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = { /* TODO: Handle previous */ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous")
            }
            Button(onClick = { /* TODO: Handle play/pause */ }) {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play")
            }
            Button(onClick = { /* TODO: Handle next */ }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }
    }

    @Composable
    fun MusicInfo() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Song Title", style = MaterialTheme.typography.titleSmall)
            Text(text = "Artist Name", style = MaterialTheme.typography.labelSmall)
        }
    }

    @Composable
    fun Playlist() {
        val songs = listOf("Song 1", "Song 2", "Song 3") // Example songs

        LazyColumn {
            items(songs) { song ->
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = song)
                }
            }
        }
    }




    @Preview
    @Composable
    fun PreviewProductDetailScreen() {
        MusicPlayerTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MusicPlayerScreen()
            }
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

    val Typography = Typography (
        bodySmall = androidx.compose.ui.text.TextStyle(
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
    fun MusicPlayerTheme(
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