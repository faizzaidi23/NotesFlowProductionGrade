package com.example.noteflowproduction.Repositories

import com.example.noteflowproduction.Database.Folder
import kotlinx.coroutines.flow.Flow

interface folderDao{

    //To get all the folders
    fun getAllFolders():Flow<List<Folder>>

    //To add a new folder
    fun addFolder(folder: Folder)

    //To update a folder
    fun updateFolder(folder: Folder)

    //To delete a folder
    fun deleteFolder(folder: Folder)


}