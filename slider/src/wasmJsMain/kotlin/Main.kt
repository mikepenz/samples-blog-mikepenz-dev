import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ComposeViewport

@OptIn(ExperimentalComposeUiApi::class)
fun main() = ComposeViewport { Demo() }

// The blog's palette (blog.mikepenz.dev), so a sample looks like part of the post. The blog follows the reader's
// system setting (prefers-color-scheme), and so does the sample: isSystemInDarkTheme() reads the same media query.
private val Light = lightColorScheme(
    primary = Color(0xFF0D716B), onPrimary = Color.White,
    background = Color(0xFFFAFAF6), onBackground = Color(0xFF121715),
    surface = Color(0xFFFAFAF6), onSurface = Color(0xFF121715),
    surfaceVariant = Color(0xFFECECE6), onSurfaceVariant = Color(0xFF4D5752),
    secondaryContainer = Color(0xFFDCE7E4), surfaceContainerHighest = Color(0xFFECECE6), outline = Color(0xFF4D5752),
)
private val Dark = darkColorScheme(
    primary = Color(0xFF3FD0C8), onPrimary = Color(0xFF051211),
    background = Color(0xFF151B19), onBackground = Color(0xFFE8EBE6),
    surface = Color(0xFF151B19), onSurface = Color(0xFFE8EBE6),
    surfaceVariant = Color(0xFF1D2523), onSurfaceVariant = Color(0xFFA1AAA3),
    secondaryContainer = Color(0xFF1F3B38), surfaceContainerHighest = Color(0xFF1D2523), outline = Color(0xFFA1AAA3),
)

@Composable
fun Demo() {
    var text by remember { mutableStateOf("Edit me") }
    var size by remember { mutableStateOf(32f) }
    var upper by remember { mutableStateOf(false) }
    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) Dark else Light) {
        Surface(Modifier.fillMaxSize()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(if (upper) text.uppercase() else text, fontSize = size.sp)
                OutlinedTextField(text, { text = it }, label = { Text("Text") }, singleLine = true, modifier = Modifier.fillMaxWidth())
                Text("Size: ${size.toInt()} sp")
                Slider(size, { size = it }, valueRange = 12f..64f)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Switch(upper, { upper = it })
                    Text("Uppercase")
                }
            }
        }
    }
}
