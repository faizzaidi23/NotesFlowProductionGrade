package com.example.noteflowproduction.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteflowproduction.Database.Folder
import com.example.noteflowproduction.Repositories.FolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*

This file the FolderViewModel is the state Holder and business logic executor for the application
its primary job is to manage the flow of the data between the FolderRepository the data source
and the UI jetpack compose ensuring the UI always displays the current, correct state of the folders

*/

@HiltViewModel
class FolderViewModel @Inject constructor(
    private val folderRepository: FolderRepository
) : ViewModel() {

    private val _allFolders = MutableStateFlow<List<Folder>>(emptyList())
    val allFolders: StateFlow<List<Folder>> = _allFolders.asStateFlow()


    private val _selectedFolder = MutableStateFlow<Folder?>(null)
    val selectedFolder: StateFlow<Folder?> = _selectedFolder.asStateFlow()

    init {
        loadAllFolders()
    }


    private fun loadAllFolders() {
        viewModelScope.launch {
            folderRepository.getAllFolders().collect { folders ->
                _allFolders.value = folders
            }
        }
    }


    fun addFolder(folder: Folder) {
        viewModelScope.launch {
            folderRepository.addFolder(folder)
        }
    }


    fun updateFolder(folder: Folder) {
        viewModelScope.launch {
            folderRepository.updateFolder(folder)
        }
    }


    fun deleteFolder(folder: Folder) {
        viewModelScope.launch {
            folderRepository.deleteFolder(folder)
        }
    }


    fun selectFolder(folder: Folder) {
        _selectedFolder.value = folder
    }


    fun clearSelectedFolder() {
        _selectedFolder.value = null
    }
}
