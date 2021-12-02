package com.example.marvel.data.local

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun dateToLong(value: Date) : Long = value.time

    @TypeConverter
    fun longToDate(value: Long) : Date = Date(value)

}