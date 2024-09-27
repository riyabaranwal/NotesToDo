package eu.tutorials.notestodo1.data

import eu.tutorials.notestodo1.NoteItem
import kotlinx.coroutines.flow.Flow

class NotesRepository(private val notesDao: NotesDao) {
    suspend fun addANote(note: NoteItem) {
        notesDao.addANote(note)
    }
    fun getAllNotes(): Flow<List<NoteItem>> = notesDao.getAllNotes()
    fun getNoteById(id: Int): Flow<NoteItem> {
        return notesDao.getNoteById(id)
    }
    suspend fun updateNote(note: NoteItem) {
        notesDao.updateNote(note)
    }
    suspend fun deleteNote(note: NoteItem) {
        notesDao.deleteNote(note)
    }
}