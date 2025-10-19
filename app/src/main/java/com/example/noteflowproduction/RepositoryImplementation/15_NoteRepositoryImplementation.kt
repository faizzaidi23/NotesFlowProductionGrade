package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImplementation(private val noteDao:NoteDao){

    fun getAllNotes():Flow<List<Note>> = noteDao.showAllNotes()


    //Adding a new note
    suspend fun addNote(note: Note){
        noteDao.addNote(note=note)
    }

    //Updating a note
    suspend fun updateNote(note: Note){
        noteDao.updateNote(note=note)
    }

    //Deleting a note
    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note=note)
    }

    //Getting a new note by Id
    suspend fun getNoteById(id: Int){
        noteDao.getNoteById(id=id)
    }

    //Getting a note by folder id
    fun getNoteByFolderId(folderId: Int):Flow<List<Note>>{
        return noteDao.getNoteByFolderId(folderId = folderId)
    }

    //Getting all the notes by a tag
    fun getNotesByTag(tagId: Int):Flow<List<Note>>{
        return noteDao.getNotesForTag(tagId = tagId)
    }

}