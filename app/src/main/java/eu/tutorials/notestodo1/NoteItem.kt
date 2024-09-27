package eu.tutorials.notestodo1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes-table")
data class NoteItem(
    @ColumnInfo(name = "notes-title")
    var title: String,
    @ColumnInfo(name = "notes-no")
    var noteNo: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "is-editing")
    var isEditing: Boolean = false,
    @ColumnInfo(name = "notes-content")
    var Content: String = " "
)
object DummyNote{
    val notes = listOf(
        NoteItem("Mine",1,1),
        NoteItem("Your",2,2),
        NoteItem("Our",3,3),
    )
}
