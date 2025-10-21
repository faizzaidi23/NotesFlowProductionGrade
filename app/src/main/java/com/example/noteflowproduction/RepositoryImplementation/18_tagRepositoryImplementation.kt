package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.NoteDao
import com.example.noteflowproduction.Database.NoteTagCrossRef
import com.example.noteflowproduction.Database.NoteTagCrossRefDao
import com.example.noteflowproduction.Database.Tag
import com.example.noteflowproduction.Database.TagDao
import com.example.noteflowproduction.Repositories.tagRepository
import kotlinx.coroutines.flow.Flow

class TagRepositoryImplementation(
    private val tagDao: TagDao,
    private val noteDao: NoteDao,
    private val noteTagCrossRefDao: NoteTagCrossRefDao
): tagRepository {

    //Get all tags
    override fun getAllTags():Flow<List<Tag>>{
        return tagDao.getAllTags()
    }

    //Add a Tag
    override suspend fun addTag(tagId: Tag){
        tagDao.addTag(tag=tagId)
    }

    //update a tag
    override suspend fun updateTag(tagId: Tag){
        tagDao.updateTag(tag=tagId)
    }

    //delete a tag
    override suspend fun deleteTag(tagId: Tag){
        tagDao.deleteTag(tag=tagId)
    }

    //get all notes for a tag
    override fun getAllNotesForTag(tagId: Int):Flow<List<Note>>{
        return noteDao.getNotesForTag(tagId = tagId)
    }

    //get tags for note
    override fun getAllTagsForNote(noteId: Int):Flow<List<Tag>>{
        return tagDao.getTagsForNote(noteId = noteId)
    }

    //Add a tag to a note (create the relationship)
    suspend fun addTagToNote(noteId: Int, tagId: Int) {
        noteTagCrossRefDao.addTagNote(NoteTagCrossRef(noteId, tagId))
    }

    //Remove a tag from a note (remove the relationship)
    suspend fun removeTagFromNote(noteId: Int, tagId: Int) {
        noteTagCrossRefDao.removeTagFromNote(NoteTagCrossRef(noteId, tagId))
    }

    //Clear all tags from a note
    suspend fun clearTagsForNote(noteId: Int) {
        noteTagCrossRefDao.clearTagsForNote(noteId)
    }

    //Clear all notes from a tag
    suspend fun clearNotesForTag(tagId: Int) {
        noteTagCrossRefDao.clearNotesForTag(tagId)
    }
}