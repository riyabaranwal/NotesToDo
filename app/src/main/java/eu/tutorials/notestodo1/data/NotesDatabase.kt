package eu.tutorials.notestodo1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.tutorials.notestodo1.NoteItem

@Database(
    entities = [NoteItem::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase()  {
    abstract fun NotesDao(): NotesDao

}