package com.example.noteflowproduction.Hilt

import com.example.noteflowproduction.Database.FolderDao
import com.example.noteflowproduction.Database.NoteDao
import com.example.noteflowproduction.Database.ReminderDao
import com.example.noteflowproduction.Database.TagDao
import com.example.noteflowproduction.Repositories.FolderRepository
import com.example.noteflowproduction.Repositories.NoteRepository
import com.example.noteflowproduction.Repositories.ReminderRepository
import com.example.noteflowproduction.Repositories.tagRepository
import com.example.noteflowproduction.RepositoryImplementation.FolderRepositoryImplementation
import com.example.noteflowproduction.RepositoryImplementation.NoteRepositoryImplementation
import com.example.noteflowproduction.RepositoryImplementation.ReminderRepositoryImplementation
import com.example.noteflowproduction.RepositoryImplementation.TagRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
This module tells Hilt how to provide Repository implementations
When a ViewModel asks for NoteRepository, Hilt will inject NoteRepositoryImplementation
This follows the Dependency Inversion Principle - depend on abstractions (interfaces), not concrete classes
*/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImplementation(noteDao)
    }

    @Provides
    @Singleton
    fun provideFolderRepository(folderDao: FolderDao): FolderRepository {
        return FolderRepositoryImplementation(folderDao)
    }

    @Provides
    @Singleton
    fun provideTagRepository(tagDao: TagDao, noteDao: NoteDao): tagRepository {
        return TagRepositoryImplementation(tagDao, noteDao)
    }

    @Provides
    @Singleton
    fun provideReminderRepository(reminderDao: ReminderDao): ReminderRepository {
        return ReminderRepositoryImplementation(reminderDao)
    }
}

