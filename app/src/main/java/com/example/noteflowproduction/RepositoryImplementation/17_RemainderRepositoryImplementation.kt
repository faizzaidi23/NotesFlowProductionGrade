package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.Reminder
import com.example.noteflowproduction.Database.ReminderDao
import kotlinx.coroutines.flow.Flow

class ReminderRepository(private val reminderDao:ReminderDao){

    //To get all the reminders
    fun getAllReminders():Flow<List<Reminder>>{
        return reminderDao.showAllReminders()
    }

    //Add a reminder
    suspend fun addReminder(reminder: Reminder){
        reminderDao.addReminder(reminder = reminder)
    }

    //update a reminder
    suspend fun updateReminder(reminder: Reminder){
        reminderDao.updateReminder(reminder=reminder)
    }

    //delete a reminder
    suspend fun deleteReminder(reminder:Reminder){
        reminderDao.deleteReminder(reminder=reminder)
    }

    //get reminders for note
    fun getReminderForNote(noteId:Int):Flow<List<Reminder>>{
        return reminderDao.getRemindersForNote(noteId=noteId)
    }

    //get reminders for tag
    fun getReminderForTag(tagId: Int):Flow<List<Reminder>>{
        return reminderDao.getRemindersForTag(tagId = tagId)
    }
}