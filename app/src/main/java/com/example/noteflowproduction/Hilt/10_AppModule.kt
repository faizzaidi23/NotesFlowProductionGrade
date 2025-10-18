package com.example.noteflowproduction.Hilt

import android.content.Context
import androidx.room.Room
import com.example.noteflowproduction.Database.AppDatabase
import com.example.noteflowproduction.Database.FolderDao
import com.example.noteflowproduction.Database.NoteDao
import com.example.noteflowproduction.Database.NoteTagCrossRefDao
import com.example.noteflowproduction.Database.ReminderDao
import com.example.noteflowproduction.Database.TagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import javax.inject.Singleton


/*
The = syntax is an expression body.
kotlin automatically returns the result of the expression on the right side
we do not need to use the return keyword

we should use expression bodies when

Single expression--> The function is just one line or expression
Cleaner code--> Removes the boilerPlate code
Type inference: if return type is obvious we can omit it r
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "noteflow_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao=database.noteDao()

    @Provides
    fun provideFolderDao(database: AppDatabase): FolderDao = database.folderDao()

    @Provides
    fun provideTagDao(database: AppDatabase): TagDao=database.tagDao()

    @Provides
    fun provideReminderDao(database: AppDatabase): ReminderDao = database.reminderDao()

    @Provides
    fun provideNoteTagCrossRefDao(database: AppDatabase): NoteTagCrossRefDao = database.noteTagCrossRefDao()

    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO


}