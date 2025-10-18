package com.example.noteflowproduction.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteTagCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTagNote(link: NoteTagCrossRef)

    @Delete
    suspend fun removeTagFromNote(link: NoteTagCrossRef)

    @Query("delete from note_tag_cross_ref where id = :noteId")
    suspend fun clearTagsForNote(noteId: Int)

    @Query("delete from note_tag_cross_ref where tagId = :tagId")
    suspend fun clearNotesForTag(tagId: Int)
}