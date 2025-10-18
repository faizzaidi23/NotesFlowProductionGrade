package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository{

    //To get all the notes
    fun getAllNotes():Flow<List<Note>>

    //To get a note by id
    suspend fun getNoteById(id: Int):Note?

    //To add a note
    suspend fun addNote(note: Note)

    //To update a note
    suspend fun updateNote(note: Note)

    //To delete a note
    suspend fun deleteNote(note: Note)

    //To get notes by folder
    fun getNotesByFolder(folderId: Int):Flow<List<Note>>

    //To get notes by tag
    fun getNotesByTag(tagId: Int):Flow<List<Note>>
}