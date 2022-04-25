package com.javidev.jetnote.util

import java.text.SimpleDateFormat
import java.util.*

// este metodo lo podria usar en el text composable
fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aa",Locale.getDefault())
    return  format.format(date)
}