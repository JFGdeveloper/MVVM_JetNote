package com.javidev.jetnote.data

import com.javidev.jetnote.data.model.Note

class NotesData{
    fun loadNotes(): List<Note>{

        var notes = listOf<Note>(
            Note(title = "Un buen dia", description = "Hoy tube suerte"),
            Note(title = "Mañana medico", description = "Revision en el dentista"),
            Note(title = "Recoger a los peques", description = "El miercoles tengo que recoger a las niñas del cole"),
            Note(title = "Comprar hilo", description = "Me falta hilo para coser el pantalon"),
            Note(title = "Apuntarme al gym", description = "Objetivo para el verano, bajar de peso 5kg")
        )
        return notes
    }
}