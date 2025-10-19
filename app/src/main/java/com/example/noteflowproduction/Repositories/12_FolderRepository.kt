package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Folder
import kotlinx.coroutines.flow.Flow

interface FolderRepository{

    //To get all the folders
    fun getAllFolders():Flow<List<Folder>>

    //To add a new folder
    suspend fun addFolder(folder: Folder)

    //To update a folder
    suspend fun updateFolder(folder: Folder)

    //To delete a folder
    suspend fun deleteFolder(folder: Folder)


}