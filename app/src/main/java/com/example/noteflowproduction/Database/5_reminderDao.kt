package com.example.noteflowproduction.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao{

    @Insert
    suspend fun addReminder(reminder:Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    // show all the reminders
    @Query("select * from reminders")
    fun showAllReminders():Flow<List<Reminder>>

    //reminders for a specific note
    @Query("select * from reminders where noteId = :noteId")
    fun getRemindersForNote(noteId: Int):Flow<List<Reminder>>

    @Query("""
        select distinct r.* from reminders r
        inner join notes n on r.noteId = n.id
        inner join note_tag_cross_ref x on x.id = n.id
        where x.tagId = :tagId
    """)
    fun getRemindersForTag(tagId: Int):Flow<List<Reminder>>

}