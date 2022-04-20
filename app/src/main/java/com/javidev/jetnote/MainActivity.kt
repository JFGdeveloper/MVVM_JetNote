package com.javidev.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.javidev.jetnote.data.NotesData
import com.javidev.jetnote.presentation.ui.screens.noteScreen.NoteScreen
import com.javidev.jetnote.presentation.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {

    val notes = NotesData().loadNotes()

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NoteScreen(notes = notes,{},{})
                }
            }
        }
    }
}



@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteTheme {
        NoteScreen(NotesData().loadNotes(),{},{})
    }
}