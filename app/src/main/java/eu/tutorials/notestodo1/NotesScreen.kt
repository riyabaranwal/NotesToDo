package eu.tutorials.notestodo1


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement



@Composable
fun NotesScreen(modifier: Modifier, navController: NavController,viewModel: NotesViewModel) {
    Surface(
        color = Color.Black, // Set the background color to black
        modifier = Modifier.fillMaxSize()
    ) {
        var showDialog by remember { mutableStateOf(false) }
        var NotesCopy by remember { mutableStateOf(listOf<NoteItem>()) }
        var titleName by remember { mutableStateOf("") }
        var sequenceNo by remember { mutableStateOf("") }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Notes",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
//                    items(NotesCopy) {
//                        note2 ->
//                        NotesList(navController = navController,
//                            note = note2,
//                            onDeleteClick = {
//                            NotesCopy = NotesCopy.filter { it.id != note2.id }
//                        },
//                            onClick = {
//                                navController.navigate("NotesDetail_screen/${note2.id}")
//                            })
                    items(
                        DummyNote.notes
                    ){
                            note ->
                        NotesList( note = note, onDeleteClick = {  NotesCopy = NotesCopy.filter { it.id != note.id } }, navController = navController)

                    }
                }

            }
            Button(
                onClick = { showDialog = true},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            )
            {
                Text(text = "+")
            }
        }

        if (showDialog) {
            AlertDialog(onDismissRequest = { showDialog = false },
                confirmButton = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {
                            if (titleName.isNotBlank() && sequenceNo.isNotBlank()) {
                                val newNotes = NoteItem(
                                    id = NotesCopy.size + 1,
                                    title = titleName,
                                    noteNo = sequenceNo.toIntOrNull() ?: 0

                                )
                                NotesCopy = NotesCopy + newNotes
                                showDialog = false
                                titleName = ""
                                sequenceNo = ""
                            }
                        }) {
                            Text("Add")
                        }
                        Button(onClick = { showDialog = false }) {
                            Text("cancel")
                        }
                    }
                },
                title = { Text("Add Notes") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = titleName,
                            onValueChange = { titleName = it },
                            label = { Text(text = "title") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = sequenceNo,
                            onValueChange = { sequenceNo = it },
                            label = { Text(text = "Note Number") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        )
                    }
                }
            )
        }
    }
}


@Composable
fun NotesList(
              note: NoteItem,
              onDeleteClick: () -> Unit,
//              onClick: () -> Unit
              navController: NavController
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(20)
            )
            .clickable { navController.navigate("NotesDetail_screen/${note.id}") }, // Add click handler
        // horizontalArrangement = SpaceBetween
    ) {
        Text(
            text = "${note.noteNo}. ",
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = " ${note.title}",
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
        Row(modifier = Modifier.padding(8.dp)) {

            IconButton(onClick = { onDeleteClick() }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }

        }
    }
}




