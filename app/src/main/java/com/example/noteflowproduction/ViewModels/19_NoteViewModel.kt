package com.example.noteflowproduction.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*

This file the NoteViewModel is the state Holder and business logic executor for the application
its primary job is to manage the flow of the data between the NoteRepository the data source
and the UI jetpack compose ensuring the UI always displays the current, correct state of the notes

*/

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    // State for all notes---like when we want to have all the notes
    private val _allNotes = MutableStateFlow<List<Note>>(emptyList())
    val allNotes: StateFlow<List<Note>> = _allNotes.asStateFlow()

    //For one  selected note
    private val _selectedNote = MutableStateFlow<Note?>(null)
    val selectedNote: StateFlow<Note?> = _selectedNote.asStateFlow()

    // Notes by Folder
    private val _notesByFolder = MutableStateFlow<List<Note>>(emptyList())
    val notesByFolder: StateFlow<List<Note>> = _notesByFolder.asStateFlow()

    //Notes by tag
    private val _notesByTag = MutableStateFlow<List<Note>>(emptyList())
    val notesByTag: StateFlow<List<Note>> = _notesByTag.asStateFlow()

    init {
        loadAllNotes()
    }

    // Load all notes--> This function loads all the notes when we  just open the app
    private fun loadAllNotes() {
        viewModelScope.launch {
            noteRepository.getAllNotes().collect { notes ->
                _allNotes.value = notes
            }
        }
    }

    // Add a new note
    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    // Update an existing note
    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    // Delete a note
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    // Get a note by ID
    fun getNoteById(id: Int) {
        viewModelScope.launch {
            val note = noteRepository.getNoteById(id)
            _selectedNote.value = note
        }
    }

    // Get notes by folder
    fun getNotesByFolder(folderId: Int) {
        viewModelScope.launch {
            noteRepository.getNotesByFolder(folderId).collect { notes ->
                _notesByFolder.value = notes
            }
        }
    }

    // Get notes by tag
    fun getNotesByTag(tagId: Int) {
        viewModelScope.launch {
            noteRepository.getNotesByTag(tagId).collect { notes ->
                _notesByTag.value = notes
            }
        }
    }

    // Clear selected note
    fun clearSelectedNote() {
        _selectedNote.value = null
    }
}