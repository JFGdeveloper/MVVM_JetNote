package com.javidev.jetnote.presentation.ui.screens.noteScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.javidev.jetnote.R

@ExperimentalComposeUiApi
@Composable
fun NoteScreen() {
    val textState1 = remember{ mutableStateOf("")}
    val textState = remember{ mutableStateOf("")}
    val keyboardController = LocalSoftwareKeyboardController.current

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
            .height(300.dp)
            .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CustomTexField(value = textState1, actions = keyboardController)

            CustomTexField(value = textState, actions = keyboardController)

        }
    }

}


@ExperimentalComposeUiApi
@Preview
@Composable
fun PrevNote() {
    NoteScreen()
}