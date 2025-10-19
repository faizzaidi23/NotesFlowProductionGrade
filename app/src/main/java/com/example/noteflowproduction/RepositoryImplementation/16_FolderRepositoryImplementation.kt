package com.example.noteflowproduction.RepositoryImplementation

import com.example.noteflowproduction.Database.Folder
import com.example.noteflowproduction.Database.FolderDao
import com.example.noteflowproduction.Repositories.FolderRepository
import kotlinx.coroutines.flow.Flow

class FolderRepositoryImplementation(private val folderDao: FolderDao):FolderRepository{

    //Getting all the  folders
    override fun getAllFolders():Flow<List<Folder>>{
        return folderDao.showAllFolders()
    }

    //Adding a new folder
    override suspend fun addFolder(folder:Folder){
        folderDao.addFolder(folder=folder)
    }

    //Updating a folder
    override suspend fun updateFolder(folder:Folder){
        folderDao.updateFolder(folder=folder)
    }

    //Deleting a folder
    override suspend fun deleteFolder(folder:Folder){
        folderDao.deleteFolder(folder=folder)
    }


}