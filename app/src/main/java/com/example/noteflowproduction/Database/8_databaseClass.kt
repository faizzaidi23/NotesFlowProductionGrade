package com.example.noteflowproduction.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(
    entities = [
        Folder::class,
        Note::class,
        Tag::class,
        NoteTagCrossRef::class,
        Media::class,
        Reminder::class
    ],
    version = 1,
    exportSchema=false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao
    abstract fun tagDao(): TagDao
    abstract fun reminderDao(): ReminderDao
    abstract fun noteTagCrossRefDao(): NoteTagCrossRefDao
}