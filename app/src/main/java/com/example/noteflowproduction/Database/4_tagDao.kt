package com.example.noteflowproduction.Database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface TagDao{

    //To get all tags
    @Query("select * from tags")
    fun getAllTags():Flow<List<Tag>>

    @Query("""
        select tags.* from tags
        inner join note_tag_cross_ref on tags.tagId = note_tag_cross_ref.tagId
        where note_tag_cross_ref.id = :noteId
    """)
    fun getTagsForNote(noteId: Int):Flow<List<Tag>>
}