package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.Reminder
import com.example.noteflowproduction.Database.ReminderDao
import com.example.noteflowproduction.Repositories.ReminderRepository
import kotlinx.coroutines.flow.Flow

class ReminderRepositoryImplementation(private val reminderDao: ReminderDao) : ReminderRepository {

    //To get all the reminders
    override fun getAllReminders(): Flow<List<Reminder>> {
        return reminderDao.showAllReminders()
    }

    //Add a reminder
    override suspend fun addReminder(reminder: Reminder) {
        reminderDao.addReminder(reminder = reminder)
    }

    //update a reminder
    override suspend fun updateReminder(reminder: Reminder) {
        reminderDao.updateReminder(reminder = reminder)
    }

    //delete a reminder
    override suspend fun deleteReminder(reminder: Reminder) {
        reminderDao.deleteReminder(reminder = reminder)
    }

    //get reminders for note
    override fun getRemindersForNote(noteId: Int): Flow<List<Reminder>> {
        return reminderDao.getRemindersForNote(noteId = noteId)
    }

    //get reminders for tag
    override fun getRemindersForTag(tagId: Int): Flow<List<Reminder>> {
        return reminderDao.getRemindersForTag(tagId = tagId)
    }
}