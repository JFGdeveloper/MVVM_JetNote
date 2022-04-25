package com.javidev.jetnote.di

import android.content.Context
import androidx.room.Room
import com.javidev.jetnote.data.dataSource.NoteDatabase
import com.javidev.jetnote.data.dataSource.NotedatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providerNotesDao(noteDatabase: NoteDatabase): NotedatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java,"notes_db")
            .fallbackToDestructiveMigration()
            .build()
}