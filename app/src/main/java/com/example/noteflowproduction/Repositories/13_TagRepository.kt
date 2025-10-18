package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.Tag
import kotlinx.coroutines.flow.Flow

interface tagRepository{

    //to get all the tags
    fun getAllTags():Flow<List<Tag>>


    //to get all notes from a tag
    fun getAllNotesForTag(tagId: Int):Flow<List<Note>>


    //to get all tags for a note
    fun getAllTagsFroNote(noteId: Int):Flow<List<Tag>>

    //to add a tag
    suspend fun addTag(tagId: Int)

    //to update a tag
    suspend fun updateTag(tagId: Int)

    //to delete a tag
    suspend fun deleteTag(tagId: Int)


}