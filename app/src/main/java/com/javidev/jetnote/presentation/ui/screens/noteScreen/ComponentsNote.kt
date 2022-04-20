package com.javidev.jetnote.presentation.ui.screens.noteScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction


@ExperimentalComposeUiApi
@Composable
fun CustomTexField(
    value: MutableState<String>,
    keyController: SoftwareKeyboardController?,
    label: String = "Imput",
    color: Color = Color.LightGray,
    onImeAction: ()->Unit = {},
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value.value,
        onValueChange = { value.value = it },
        maxLines = 1,
        singleLine = true,
        label = { Text(text = label)},
        colors = TextFieldDefaults.textFieldColors(backgroundColor = color),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyController?.hide()
            }
        )
    )
}