package com.javidev.jetnote.data.repository

import com.javidev.jetnote.data.dataSource.NotedatabaseDao
import com.javidev.jetnote.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(val notedatabaseDao: NotedatabaseDao) {

    suspend fun addNote(note:Note)= notedatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = notedatabaseDao.upDate(note)
    suspend fun deleteNote(note: Note) = notedatabaseDao.deleteNote(note)
    suspend fun deleteAll() = notedatabaseDao.deleteAll()
    suspend fun getNote(note: Note) = notedatabaseDao.getNoteById(note.id.toString())
    fun getAll(): Flow<List<Note>> = notedatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}