package com.javidev.jetnote.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    var title: String,
    @ColumnInfo(name = "note_description")
    var description: String,
    @ColumnInfo(name = "note_date")
    var entryDay: Date = Date.from(Instant.now())
)
