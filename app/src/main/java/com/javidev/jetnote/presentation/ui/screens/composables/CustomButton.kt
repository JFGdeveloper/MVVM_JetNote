package com.javidev.jetnote.presentation.ui.screens.composables

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    shapes: Shape,
    onClick: ()->Unit,

    ) {
    Button(modifier = modifier, shape = shapes, onClick = { onClick()}) {
        Text(text = text)

    }
}