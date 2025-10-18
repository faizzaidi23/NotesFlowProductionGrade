package com.example.noteflowproduction.Database

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowInsetsCompat
import androidx.room.TypeConverter
import java.sql.Date

//Adding type converters for Color and dates

/*
Room storage limits:room only knows how to persist primitives and a few standard types
Color and Date are not supported with fail with Cannot figure out how to save this field

Color is a UI type. Converting it to an ARGB Int makes it storable and portable, so tag colors survive app restarts and migrations

Data becomes a long That lets us sort and filter date efficiently e.g the order by createdDate (queries) because it is stored as an integer

*/

class Converters{

    @TypeConverter
    fun colorToInt(color: Color): Int = color.toArgb()

    @TypeConverter
    fun intToColor(value: Int): Color = Color(value)

    @TypeConverter
    fun dateToLong(date: Date): Long = date.time

    @TypeConverter
    fun longToDate(value: Long): Date = Date(value)


}