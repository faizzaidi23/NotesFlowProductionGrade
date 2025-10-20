package com.example.noteflowproduction.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteflowproduction.Database.Reminder
import com.example.noteflowproduction.Repositories.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*

This file the ReminderViewModel is the state Holder and business logic executor for the application
its primary job is to manage the flow of the data between the ReminderRepository the data source
and the UI jetpack compose ensuring the UI always displays the current, correct state of the reminders

*/

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderRepository: ReminderRepository
) : ViewModel() {

    // State for all reminders---like when we want to have all the reminders
    private val _allReminders = MutableStateFlow<List<Reminder>>(emptyList())
    val allReminders: StateFlow<List<Reminder>> = _allReminders.asStateFlow()

    //For one selected reminder
    private val _selectedReminder = MutableStateFlow<Reminder?>(null)
    val selectedReminder: StateFlow<Reminder?> = _selectedReminder.asStateFlow()

    // Reminders by Note
    private val _remindersByNote = MutableStateFlow<List<Reminder>>(emptyList())
    val remindersByNote: StateFlow<List<Reminder>> = _remindersByNote.asStateFlow()

    // Reminders by Tag
    private val _remindersByTag = MutableStateFlow<List<Reminder>>(emptyList())
    val remindersByTag: StateFlow<List<Reminder>> = _remindersByTag.asStateFlow()

    init {
        loadAllReminders()
    }

    // Load all reminders--> This function loads all the reminders when we just open the app
    private fun loadAllReminders() {
        viewModelScope.launch {
            reminderRepository.getAllReminders().collect { reminders ->
                _allReminders.value = reminders
            }
        }
    }

    // Add a new reminder
    fun addReminder(reminder: Reminder) {
        viewModelScope.launch {
            reminderRepository.addReminder(reminder)
        }
    }

    // Update an existing reminder
    fun updateReminder(reminder: Reminder) {
        viewModelScope.launch {
            reminderRepository.updateReminder(reminder)
        }
    }

    // Delete a reminder
    fun deleteReminder(reminder: Reminder) {
        viewModelScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }

    // Get reminders by note ID
    fun getRemindersByNote(noteId: Int) {
        viewModelScope.launch {
            reminderRepository.getRemindersForNote(noteId).collect { reminders ->
                _remindersByNote.value = reminders
            }
        }
    }

    // Get reminders by tag ID
    fun getRemindersByTag(tagId: Int) {
        viewModelScope.launch {
            reminderRepository.getRemindersForTag(tagId).collect { reminders ->
                _remindersByTag.value = reminders
            }
        }
    }

    // Select a reminder (when user clicks on a reminder)
    fun selectReminder(reminder: Reminder) {
        _selectedReminder.value = reminder
    }

    // Clear selected reminder
    fun clearSelectedReminder() {
        _selectedReminder.value = null
    }
}
