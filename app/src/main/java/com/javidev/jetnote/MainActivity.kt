package com.javidev.jetnote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.javidev.jetnote.data.NotesData
import com.javidev.jetnote.data.model.Note
import com.javidev.jetnote.presentation.ui.screens.noteScreen.NoteScreen
import com.javidev.jetnote.presentation.ui.screens.noteScreen.NoteViewModel
import com.javidev.jetnote.presentation.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: NoteViewModel by viewModels()

            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                NoteApp(viewModel)
            }
        }
    }
}


// es como mi MyApp
@ExperimentalComposeUiApi
@Composable
fun NoteApp(viewModel: NoteViewModel) {
    // transforma el Flow
    val noteList = viewModel.noteList.collectAsState().value

    Surface(color = MaterialTheme.colors.background) {
        NoteScreen(
            notes = noteList,
            addNote = {
                  viewModel.addNote(it)
            },
            removeNote = {
                viewModel.removeNote(it)
            }
        )
    }
}



@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteTheme {
        //NoteScreen(NotesData().loadNotes(),{},{})
    }
}