package eu.tutorials.notestodo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

data class Notes(
    var title : String,
    var noteNo: Int,
    var isEditing : Boolean = false
)
@Composable
fun NotesScreen() {
    Surface(
        color = Color.Black, // Set the background color to black
        modifier = Modifier.fillMaxSize()
    ) {
        var showDialog by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Notes",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    color = Color.White
                )
                Button(onClick = {showDialog = true }) {
                    
                }

            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun NoteScreenPreview(){
    NotesScreen()
}