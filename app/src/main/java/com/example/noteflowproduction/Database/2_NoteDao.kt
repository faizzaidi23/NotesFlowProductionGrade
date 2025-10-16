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

    @Query("select * from notes order by folderId")
}