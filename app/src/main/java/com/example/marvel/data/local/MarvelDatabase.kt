package com.example.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel.data.local.dao.CharacterDao
import com.example.marvel.data.local.entity.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MarvelDatabase : RoomDatabase() {

    abstract val characterDao: CharacterDao


}