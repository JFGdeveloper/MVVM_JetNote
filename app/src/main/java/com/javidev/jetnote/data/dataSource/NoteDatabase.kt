package com.javidev.jetnote.data.dataSource

import androidx.room.Database
import com.javidev.jetnote.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase {
    abstract fun noteDao(): NotedatabaseDao
}