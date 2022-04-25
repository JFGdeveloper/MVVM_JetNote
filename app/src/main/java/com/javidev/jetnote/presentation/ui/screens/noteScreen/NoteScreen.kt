package com.javidev.jetnote.presentation.ui.screens.noteScreen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.jetnote.R
import com.javidev.jetnote.data.model.Note
import com.javidev.jetnote.presentation.ui.screens.composables.CustomButton
import com.javidev.jetnote.presentation.ui.screens.composables.NoteRow

@ExperimentalComposeUiApi
@Composable
fun NoteScreen(
    notes: List<Note>,
    addNote: (Note)-> Unit,
    removeNote: (Note)-> Unit
) {
    val titleState = remember{ mutableStateOf("")}
    val descriptionState = remember{ mutableStateOf("")}
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name) )},
            actions = {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = "icon topApp")

            },
            backgroundColor = MaterialTheme.colors.surface
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomTexField(
                value = titleState,
                keyController = keyboardController,
                color = Color.Transparent.copy(0.05f),
                label = "title",
                modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
            )

            CustomTexField(
                value = descriptionState,
                keyController = keyboardController,
                color = Color.Transparent.copy(0.05f),
                label = "add a description",
                modifier = Modifier.padding(top = 3.dp, bottom = 3.dp),
                onImeAction = {
                    addNote(Note(title = titleState.value, description = descriptionState.value))
                    clearImput(titleState, descriptionState)
                }
            )

            CustomButton(
                text = "ADD",
                shapes = RoundedCornerShape(12.dp),
                modifier = Modifier.width(100.dp).padding(top = 12.dp)
            ) {
                if(titleState.value.isNotEmpty() && descriptionState.value.isNotEmpty()){
                    addNote(Note(title = titleState.value, description = descriptionState.value))
                    keyboardController?.hide()
                    Toast.makeText(context,"Nota creada",Toast.LENGTH_SHORT).show()
                    Log.d("toast","Toast en pantalla")
                }
                clearImput(titleState, descriptionState)
            }
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        LazyColumn{
            items(notes){ note ->
                NoteRow(note = note, onclickcled = {
                    removeNote(note)
                    Log.d("room","position en lazycolum: ")
                })

            }
        }
    }// Column
}// composable


private fun clearImput(
    titleState: MutableState<String>,
    descriptionState: MutableState<String>
) {
    if (titleState.value.isNotEmpty() && descriptionState.value.isNotEmpty()) {
        titleState.value = ""
        descriptionState.value = ""
    }
}




@ExperimentalComposeUiApi
@Preview
@Composable
fun PrevNote() {
    NoteScreen(notes = emptyList(), addNote = {}, removeNote = {})
}