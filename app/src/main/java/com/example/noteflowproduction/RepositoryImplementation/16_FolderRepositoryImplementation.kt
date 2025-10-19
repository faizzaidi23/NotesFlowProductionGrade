package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Folder
import com.example.noteflowproduction.Database.FolderDao
import kotlinx.coroutines.flow.Flow

class FolderRepository(private val folderDao: FolderDao){

    //Getting all the  folders
    fun getAllFolders():Flow<List<Folder>>{
        return folderDao.showAllFolders()
    }

    //Adding a new folder
    suspend fun addFolder(folder:Folder){
        folderDao.addFolder(folder=folder)
    }

    //Updating a folder
    suspend fun updateFolder(folder:Folder){
        folderDao.updateFolder(folder=folder)
    }

    //Deleting a folder
    suspend fun deleteFolder(folder:Folder){
        folderDao.deleteFolder(folder=folder)
    }


}