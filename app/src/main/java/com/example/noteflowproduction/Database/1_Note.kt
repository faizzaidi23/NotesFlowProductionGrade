package com.example.noteflowproduction.Database

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "folders")
data class Folder(
    @PrimaryKey(autoGenerate = true)
    val folderId: Int,
    val name: String,
    val createdDate: Date = Date(System.currentTimeMillis())
)
@Entity(
    tableName="notes",
    foreignKeys = [
        ForeignKey(
            entity=Folder::class,
            parentColumns = ["folderId"],
            childColumns = ["id"],
            onDelete=ForeignKey.CASCADE
        )
    ]
)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String,
    val createdDate:Date = Date(System.currentTimeMillis()),
    val modifiedDate:Date = Date(System.currentTimeMillis())
)

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey(autoGenerate = true)
    val tagId: Int,
    val name: String,
    val color: Color,
    val createdDate: Date=Date(System.currentTimeMillis())
)


//This table is a cross referenced table that means the notes can have any tags and the tags too  can have any notes
@Entity(
    tableName = "note_tag_cross_ref",
    primaryKeys = ["id", "tagId"],
    foreignKeys = [
        ForeignKey(
            entity = Note::class,
            parentColumns = ["id"],
            childColumns = ["tagId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["tagId"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class NoteTagCrossRef(
    val id: Int,
    val tagId: Int
)

//Media Entity
@Entity(
    tableName = "media",
    foreignKeys = [
        ForeignKey(
            entity=Note::class,
            parentColumns = ["id"],
            childColumns = ["mediaId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Media(
    @PrimaryKey(autoGenerate = true)
    val mediaId: Int,
    val mediaType: String,
    val filePath: String,
    val createdDate: Date = Date(System.currentTimeMillis())
)

//Reminder Entity
@Entity(
    tableName="reminders",
    foreignKeys = [
        ForeignKey(
            entity = Note::class,
            parentColumns = ["id"],
            childColumns = ["noteId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val reminderId: Int,
    val noteId: Int,
    val reminderDateTime: Long,
    val isRecurringFrequency: String?
)
