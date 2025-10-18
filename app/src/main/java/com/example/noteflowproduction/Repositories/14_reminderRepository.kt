package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Reminder
import kotlinx.coroutines.flow.Flow

interface ReminderRepository{

    //To get all the reminders
    fun getAllReminders():Flow<List<Reminder>>

    //To get all the reminders for a particular note
    fun getRemindersForNote(noteId: Int):Flow<List<Reminder>>

    //To get all the reminders for a particular tag
    fun getRemindersForTag(tagId: Int):Flow<List<Reminder>>

    //To add a reminder
    suspend fun addReminder(reminder: Reminder)

    //To update a reminder
    suspend fun updateReminder(reminder: Reminder)

    //To delete a reminder
    suspend fun deleteReminder(reminder: Reminder)


}