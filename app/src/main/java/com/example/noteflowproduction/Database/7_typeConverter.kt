package com.example.noteflowproduction.Database

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowInsetsCompat
import androidx.room.TypeConverter
import java.util.Date

//Adding type converters for Color and dates

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