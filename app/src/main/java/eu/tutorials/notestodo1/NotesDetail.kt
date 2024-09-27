package eu.tutorials.notestodo1


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun NotesDetail(
    navController: NavController,
    noteId: Int,
    viewModel: NotesViewModel,
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scffoldState = rememberScaffoldState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Notes",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(24.dp))
            NotesTextField(
                label = "Title",
                value = viewModel.notesTitleState,
                onValueChange = { viewModel.onTitleChange(it) })
            NotesTextField(
                label = "Type Here.....",

                value = viewModel.notesContentState,
                onValueChange = {viewModel.onContentChange(it)})
    }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            if(viewModel.notesTitleState.isNotBlank() && viewModel.notesContentState.isNotBlank()){
                if (noteId.toLong() != 0L){
                    //  update note
                }
                else{
                    // add note
                    viewModel.addANote(
                        NoteItem(
                            id = noteId,
                            title = viewModel.notesTitleState.trim(),
                            noteNo = viewModel.notesContentState.trim().toInt(),
                            Content = viewModel.notesContentState.trim(),
                        )
                    )
                    snackMessage.value = "Note Added"
                }
            }
            else{
                snackMessage.value = "Enter notes"
            }
            scope.launch {
                //scffoldState.snackbarHostState.showSnackbar(snackMessage.value)
               // snackMessage.value
               // navController.navigateUp()
            }
        }) {

        }
}
}
@Composable
fun NotesTextField(
    label:String,
    value:String,
    onValueChange:(String)->Unit

){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        textStyle = TextStyle(color = Color.Black)
    )

}

@Preview(showBackground = true)
@Composable

fun NotesTextFieldPreview() {
   // NotesTextField(label = "text", value = "text" , onValueChange = {})
    NotesDetail(navController = NavController(LocalContext.current), noteId = 1, viewModel = NotesViewModel())
}