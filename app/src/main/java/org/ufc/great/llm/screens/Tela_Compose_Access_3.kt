package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.musicagpt4llmtest.R

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                MusicPlayerTheme {
                    val musicViewModel by viewModels<Tela_Compose_3.MusicViewModel>()
                    MusicPlayerScreen(musicViewModel)
                }
            }
        }

    }

    @Composable
    fun MusicPlayerScreen(viewModel: Tela_Compose_3.MusicViewModel) {
        val currentSong by viewModel.currentSong.observeAsState()
        val isPlaying by viewModel.isPlaying.observeAsState(false)
        val songList by viewModel.songList.observeAsState(emptyList())

        MusicPlayerTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                currentSong?.let { song ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = song.albumArtRes),
                            contentDescription = "Capa do álbum de ${song.title}",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(16.dp)
                        )
                        Text(
                            text = song.title,
                            style = MaterialTheme.typography.titleSmall,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = song.artist,
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = { viewModel.onPrevious() },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Retroceder"
                        )
                    }
                    IconButton(
                        onClick = { viewModel.onPlayPause() },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = if (isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_background),
                            contentDescription = if (isPlaying) "Pausar" else "Reproduzir"
                        )
                    }
                    IconButton(
                        onClick = { viewModel.onNext() },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Avançar"
                        )
                    }
                }

                LinearProgressIndicator(
                    progress = viewModel.playbackProgress.observeAsState(0f).value,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(text = "Playlist", style = MaterialTheme.typography.titleSmall)
                LazyColumn {
                    items(songList.size) { index ->
                        val song = songList[index]
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { viewModel.onSelectSong(index) }
                                .padding(8.dp)
                        ) {
                            Text(
                                text = song.title,
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start
                            )
                            Text(
                                text = song.artist,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun PreviewProductDetailScreen() {

    }

    private val DarkColorPalette = darkColorScheme(
        primary = Color(0xFFBB86FC),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6)
    )

    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onSurfaceVariant = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6)
    )

    val Typography = Typography(
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dxp)
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