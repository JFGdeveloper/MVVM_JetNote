package com.javidev.jetnote.presentation.ui.screens.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.javidev.jetnote.data.model.Note
import java.time.format.DateTimeFormatter

@Composable
fun NoteRow(
    note: Note,
    modifier: Modifier = Modifier,
    onclickcled: (Note)->Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
        color = Color.Transparent.copy(0.1f),
        elevation = 3.dp
    ) {
        Column(modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable {onclickcled(note) }) {
            Text(text = note.title , style = MaterialTheme.typography.subtitle1)
            Text(text = note.description , style = MaterialTheme.typography.subtitle2)
            Text(
                text = note.entryDay.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.caption
            )
        }
    }
    
}