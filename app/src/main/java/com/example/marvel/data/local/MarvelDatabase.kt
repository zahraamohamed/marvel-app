package com.example.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel.data.local.dao.*
import com.example.marvel.data.local.entity.*


@Database(entities = [CharacterEntity::class, CreatorEntity::class, SeriesEntity::class, SearchEntity::class,ComicsEntity::class],
    version = 1)
@TypeConverters(Converters::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
    abstract val creatorDao: CreatorDao
    abstract val seriesDao: SeriesDao
    abstract val searchDao: SearchDao
    abstract val comicsDao: ComicsDao
}