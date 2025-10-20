package com.example.noteflowproduction.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteflowproduction.Database.Note
import com.example.noteflowproduction.Database.Tag
import com.example.noteflowproduction.Repositories.tagRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*

This file the TagViewModel is the state Holder and business logic executor for the application
its primary job is to manage the flow of the data between the tagRepository the data source
and the UI jetpack compose ensuring the UI always displays the current, correct state of the tags

*/

@HiltViewModel
class TagViewModel @Inject constructor(
    private val tagRepository: tagRepository
) : ViewModel() {


    private val _allTags = MutableStateFlow<List<Tag>>(emptyList())
    val allTags: StateFlow<List<Tag>> = _allTags.asStateFlow()


    private val _selectedTag = MutableStateFlow<Tag?>(null)
    val selectedTag: StateFlow<Tag?> = _selectedTag.asStateFlow()


    private val _tagsForNote = MutableStateFlow<List<Tag>>(emptyList())
    val tagsForNote: StateFlow<List<Tag>> = _tagsForNote.asStateFlow()


    private val _notesForTag = MutableStateFlow<List<Note>>(emptyList())
    val notesForTag: StateFlow<List<Note>> = _notesForTag.asStateFlow()

    init {
        loadAllTags()
    }


    private fun loadAllTags() {
        viewModelScope.launch {
            tagRepository.getAllTags().collect { tags ->
                _allTags.value = tags
            }
        }
    }


    fun addTag(tag: Tag) {
        viewModelScope.launch {
            tagRepository.addTag(tag)
        }
    }


    fun updateTag(tag: Tag) {
        viewModelScope.launch {
            tagRepository.updateTag(tag)
        }
    }


    fun deleteTag(tag: Tag) {
        viewModelScope.launch {
            tagRepository.deleteTag(tag)
        }
    }


    fun getTagsForNote(noteId: Int) {
        viewModelScope.launch {
            tagRepository.getAllTagsForNote(noteId).collect { tags ->
                _tagsForNote.value = tags
            }
        }
    }


    fun getNotesForTag(tagId: Int) {
        viewModelScope.launch {
            tagRepository.getAllNotesForTag(tagId).collect { notes ->
                _notesForTag.value = notes
            }
        }
    }


    fun selectTag(tag: Tag) {
        _selectedTag.value = tag
    }


    fun clearSelectedTag() {
        _selectedTag.value = null
    }
}
