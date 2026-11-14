import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ComposeViewport

@OptIn(ExperimentalComposeUiApi::class)
fun main() = ComposeViewport { Demo() }

@Composable
fun Demo() {
    var text by remember { mutableStateOf("Edit me") }
    var size by remember { mutableStateOf(32f) }
    var upper by remember { mutableStateOf(false) }
    MaterialTheme {
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
