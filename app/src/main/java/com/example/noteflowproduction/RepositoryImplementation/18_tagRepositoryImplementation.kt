package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Tag
import com.example.noteflowproduction.Database.TagDao
import kotlinx.coroutines.flow.Flow

class TagRepository(private val tagDao: TagDao){

    //Get all tags
    fun getAllTags():Flow<List<Tag>>{
        return tagDao.getAllTags()
    }

    //Add a Tag
    suspend fun addTag(tag: Tag){
        tagDao.addTag(tag=tag)
    }

    //update a tag
    suspend fun updateTag(tag: Tag){
        tagDao.updateTag(tag=tag)
    }

    //delete a tag
    suspend fun deleteTag(tag: Tag){
        tagDao.deleteTag(tag=tag)
    }

    //get tags for note
    fun getTagsForNote(noteId: Int){
        tagDao.getTagsForNote(noteId = noteId)
    }
}