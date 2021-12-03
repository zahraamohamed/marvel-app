package com.example.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel.data.local.dao.CharacterDao
import com.example.marvel.data.local.dao.CreatorDao
import com.example.marvel.data.local.dao.SeriesDao
import com.example.marvel.data.local.entity.CharacterEntity
import com.example.marvel.data.local.entity.CreatorEntity
import com.example.marvel.data.local.entity.SeriesEntity


@Database(entities = [CharacterEntity::class, CreatorEntity::class, SeriesEntity::class],
    version = 1)
@TypeConverters(Converters::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
    abstract val creatorDao: CreatorDao
    abstract val seriesDao: SeriesDao
}