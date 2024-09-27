package eu.tutorials.notestodo1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.notestodo1.data.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val notesRepository: NotesRepository = Graph.notesRepository
): ViewModel() {
    var notesTitleState by mutableStateOf("")
    var notesContentState by mutableStateOf("")

    fun onTitleChange(newTitle: String) {
        notesTitleState = newTitle
    }
    fun onContentChange(newContent: String) {
        notesContentState = newContent

    }
   lateinit var getAllNotes : Flow<List<NoteItem>>
    init {
        viewModelScope.launch {
            getAllNotes = notesRepository.getAllNotes()
        }
    }
    fun addANote(note: NoteItem) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.addANote(note)
        }
    }
    fun getNoteById(id: Int): Flow<NoteItem> {
        return notesRepository.getNoteById(id)
    }
    fun deleteNote(note: NoteItem) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.deleteNote(note)
        }
    }
    fun updateNote(note: NoteItem) {
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.updateNote(note)
        }
    }
}