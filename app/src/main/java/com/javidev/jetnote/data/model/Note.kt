package com.javidev.jetnote.data.model

import java.time.LocalDateTime
import java.util.*

data class Note(
    var id: UUID = UUID.randomUUID(),
    var title: String,
    var description: String,
    var entryDay: LocalDateTime = LocalDateTime.now()
)
