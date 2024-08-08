package org.ufc.great.llm.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.perfilgpt4llmtest.R

class Tela_Compose_Access_3<VisualTransformation> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProfileScreen()
                }
            }
        }

    }

    @Composable
    fun ProfileScreen() {
        var name by remember { mutableStateOf(TextFieldValue("John")) }
        var surname by remember { mutableStateOf(TextFieldValue("Doe")) }
        var email by remember { mutableStateOf(TextFieldValue("john.doe@example.com")) }
        var phone by remember { mutableStateOf(TextFieldValue("+1234567890")) }
        var isEditing by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage()

            Spacer(modifier = Modifier.height(16.dp))

            if (isEditing) {
                EditableProfileField(value = name, onValueChange = { name = it }, label = "Name")
                EditableProfileField(value = surname, onValueChange = { surname = it }, label = "Surname")
                EditableProfileField(value = email, onValueChange = { email = it }, label = "Email")
                EditableProfileField(value = phone, onValueChange = { phone = it }, label = "Phone")
            } else {
                ProfileField(value = name.text, label = "Name")
                ProfileField(value = surname.text, label = "Surname")
                ProfileField(value = email.text, label = "Email")
                ProfileField(value = phone.text, label = "Phone")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                IconButton(
                    onClick = { isEditing = !isEditing },
                    modifier = Modifier.semantics {
                        contentDescription = if (isEditing) "Save" else "Edit"
                    }
                ) {
                    Icon(
                        imageVector = if (isEditing) Icons.Default.Done else Icons.Default.Edit,
                        contentDescription = null // Decorative image, no content description needed
                    )
                }
            }
        }
    }

    @Composable
    fun ProfileImage() {
        val painter = painterResource(id = R.drawable.ic_launcher_background)
        Image(
            painter = painter,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .clickable { /* Handle image click to update profile picture */ }
                .semantics { contentDescription = "Profile Image" },
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun ProfileField(value: String, label: String) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            Text(text = value, style = MaterialTheme.typography.bodySmall)
        }
    }

    @Composable
    fun EditableProfileField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit, label: String) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            TextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text(text = label) }
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewProductDetailScreen() {
        ProfileTheme {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                ProfileScreen()
            }
        }
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
    fun ProfileTheme(
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