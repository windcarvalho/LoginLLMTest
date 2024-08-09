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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicagpt4llmtest.R

class Tela_Compose_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                val musicViewModel by viewModels<MusicViewModel>()
                MusicPlayerScreen(musicViewModel)
            }
        }
    }

    @Composable
    fun MusicPlayerScreen(viewModel: MusicViewModel) {
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
                            contentDescription = "Album Art",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(16.dp)
                        )
                        Text(
                            text = song.title,
                            style = MaterialTheme.typography.titleMedium,
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
                    IconButton(onClick = { viewModel.onPrevious() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Previous"
                        )
                    }
                    IconButton(onClick = { viewModel.onPlayPause() }) {
                        Icon(
                            painter = painterResource(id = if (isPlaying) R.drawable.ic_launcher_background else R.drawable.ic_launcher_background),
                            contentDescription = "Play/Pause"
                        )
                    }
                    IconButton(onClick = { viewModel.onNext() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Next"
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
                            Text(text = song.title, modifier = Modifier.weight(1f))
                            Text(text = song.artist, textAlign = TextAlign.End)
                        }
                    }
                }
            }
        }
    }

    data class Song(
        val title: String,
        val artist: String,
        val albumArtRes: Int
    )

    class MusicRepository {
        fun getSongs(): List<Song> {
            return listOf(
                Song("Song 1", "Artist 1", R.drawable.ic_launcher_background),
                Song("Song 2", "Artist 2", R.drawable.ic_launcher_background),
                Song("Song 3", "Artist 3", R.drawable.ic_launcher_background)
            )
        }
    }

    class MusicViewModel : ViewModel() {
        private val repository = MusicRepository()

        private val _currentSong = MutableLiveData<Song?>()
        val currentSong: LiveData<Song?> = _currentSong

        private val _isPlaying = MutableLiveData<Boolean>(false)
        val isPlaying: LiveData<Boolean> = _isPlaying

        private val _playbackProgress = MutableLiveData<Float>(0f)
        val playbackProgress: LiveData<Float> = _playbackProgress

        private val _songList = MutableLiveData<List<Song>>(repository.getSongs())
        val songList: LiveData<List<Song>> = _songList

        init {
            _currentSong.value = _songList.value?.firstOrNull()
        }

        fun onPlayPause() {
            _isPlaying.value = !_isPlaying.value!!
        }

        fun onPrevious() {
            _songList.value?.let { songs ->
                val currentIndex = songs.indexOf(_currentSong.value)
                if (currentIndex > 0) {
                    _currentSong.value = songs[currentIndex - 1]
                }
            }
        }

        fun onNext() {
            _songList.value?.let { songs ->
                val currentIndex = songs.indexOf(_currentSong.value)
                if (currentIndex < songs.size - 1) {
                    _currentSong.value = songs[currentIndex + 1]
                }
            }
        }

        fun onSelectSong(index: Int) {
            _songList.value?.let { songs ->
                _currentSong.value = songs[index]
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