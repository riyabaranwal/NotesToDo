package eu.tutorials.notestodo1.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.tutorials.notestodo1.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NotesDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        abstract suspend fun addANote(noteEntity: NoteItem)

        @Query("SELECT * FROM `notes-table`")
        abstract fun getAllNotes(): Flow<List<NoteItem>>

        @Update
        abstract suspend fun updateNote(noteEntity: NoteItem)

        @Delete
        abstract suspend fun deleteNote(noteEntity: NoteItem)

        @Query("SELECT * FROM `notes-table` WHERE id = :id")
        abstract fun getNoteById(id: Int): Flow<NoteItem>


}