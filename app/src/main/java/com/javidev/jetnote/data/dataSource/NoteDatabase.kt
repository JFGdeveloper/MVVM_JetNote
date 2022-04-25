package com.javidev.jetnote.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.javidev.jetnote.data.model.Note
import com.javidev.jetnote.util.DateConverter
import com.javidev.jetnote.util.UUDIConverter

// cuando nos sale el fallo de Room por no conocer el tipo
// creamos los tipos y los añadimos aqui
// con la anotacion y pasandole los tipos creados en el paquete util
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUDIConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NotedatabaseDao
}