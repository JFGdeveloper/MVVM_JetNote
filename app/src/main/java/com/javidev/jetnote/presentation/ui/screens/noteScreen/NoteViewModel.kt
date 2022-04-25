package com.javidev.jetnote.presentation.ui.screens.noteScreen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javidev.jetnote.data.NotesData
import com.javidev.jetnote.data.model.Note
import com.javidev.jetnote.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(val noteRepository: NoteRepository): ViewModel(){
    private val _noteRepository = MutableStateFlow<List<Note>>(emptyList())
    var noteList = _noteRepository.asStateFlow()

    //private var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAll().distinctUntilChanged().collect(){
                if (it.isNullOrEmpty()){
                    Log.d("room", " LA LISTA ES NULL O VACIA")
                    _noteRepository.value = it
                }else{
                    _noteRepository.value = it
                }
            }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {  noteRepository.addNote(note)}
     fun removeNote(note: Note) = viewModelScope.launch(Dispatchers.IO) { noteRepository.deleteNote(note)  }
     fun upNotes(note: Note) = viewModelScope.launch(Dispatchers.IO) { noteRepository.updateNote(note)  }


}

