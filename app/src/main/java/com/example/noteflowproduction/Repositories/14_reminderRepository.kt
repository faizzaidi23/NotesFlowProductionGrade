package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderRepository{


    fun getAllReminders():Flow<List<Reminder>>


    fun getRemindersForNote(noteId: Int):Flow<List<Reminder>>


    fun getRemindersForTag(tagId: Int):Flow<List<Reminder>>


    suspend fun addReminder(reminder: Reminder)


    suspend fun updateReminder(reminder: Reminder)


    suspend fun deleteReminder(reminder: Reminder)

}