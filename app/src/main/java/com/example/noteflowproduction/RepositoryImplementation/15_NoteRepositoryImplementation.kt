package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.NoteDao
import com.example.noteflowproduction.Repositories.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImplementation(private val noteDao:NoteDao): NoteRepository{

    override fun getAllNotes():Flow<List<Note>> = noteDao.showAllNotes()

    //Adding a new note
    override suspend fun addNote(note: Note){
        noteDao.addNote(note=note)
    }

    //Updating a note
    override suspend fun updateNote(note: Note){
        noteDao.updateNote(note=note)
    }

    //Deleting a note
    override suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note=note)
    }

    //Getting a new note by Id
    override suspend fun getNoteById(id: Int):Note?{
        return noteDao.getNoteById(id=id)
    }

    //Getting a note by folder id
    override fun getNotesByFolder(folderId: Int):Flow<List<Note>>{
        return noteDao.getNoteByFolderId(folderId = folderId)
    }

    //Getting all the notes by a tag
    override fun getNotesByTag(tagId: Int):Flow<List<Note>>{
        return noteDao.getNotesForTag(tagId = tagId)
    }

}