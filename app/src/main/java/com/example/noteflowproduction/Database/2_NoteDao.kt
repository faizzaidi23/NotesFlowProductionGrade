package com.example.noteflowproduction.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{
    @Query("select * from notes order by createdDate")
    fun showAllNotes():Flow<List<Note>>

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Transaction
    @Query("select * from notes where id = :id")
    suspend fun getNoteById(id: Int): Note?

    /*
    We do not have to use suspend keyword.
    A dao method that returns Flow should be a regular function Room provides the reactive stream and runs queries off the main thread
    We use suspend function only for one shot calls that return a value
    */
    @Query("select * from notes where folderId = :folderId order by createdDate")
    fun getNoteByFolderId(folderId:Int):Flow<List<Note>>


    //selecting all notes from a particular tag
    @Query(
        "select notes.* From notes inner join note_tag_cross_ref on notes.id = note_tag_cross_ref.id where note_tag_cross_ref.tagId = :tagId"
    )
    fun getNotesForTag(tagId:Int):Flow<List<Note>>
}