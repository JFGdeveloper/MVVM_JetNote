package com.javidev.jetnote.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date): Long{
        return date.time
    }

    @TypeConverter
    fun dateFromTimestamp(time: Long): Date?{
        return Date(time)
    }
}