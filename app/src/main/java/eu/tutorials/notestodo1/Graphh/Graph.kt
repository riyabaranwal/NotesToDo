package eu.tutorials.notestodo1.Graphh

import android.content.Context
import androidx.room.Room
import eu.tutorials.notestodo1.data.NotesDatabase
import eu.tutorials.notestodo1.data.NotesRepository

object Graph {
    lateinit var database: NotesDatabase
    val notesRepository by lazy {
        NotesRepository(
            notesDao = database.NotesDao()
        )
    }
    fun provide(context: Context) {
        database = Room.databaseBuilder(context, NotesDatabase::class.java, "notes.db").build()
    }
}