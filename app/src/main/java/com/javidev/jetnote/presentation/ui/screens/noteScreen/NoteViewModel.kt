package com.javidev.jetnote.presentation.ui.screens.noteScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.javidev.jetnote.data.NotesData
import com.javidev.jetnote.data.model.Note

class NoteViewModel: ViewModel(){

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesData().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNoteList(): List<Note>{
        return noteList
    }
}