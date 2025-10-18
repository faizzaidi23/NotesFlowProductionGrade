package com.example.noteflowproduction.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FolderDao{


    //To show  all the folders
    @Query("select * from folders order by createdDate")
    fun showAllFolders():Flow<List<Folder>>

    @Insert
    suspend fun addFolder(folder: Folder)

    @Update
    suspend fun updateFolder(folder: Folder)

    @Delete
    suspend fun deleteFolder(folder: Folder)
}