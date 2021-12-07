package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.SearchEntity


@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: List<SearchEntity>)

    @Query("Select * from Marvel_Search WHERE name LIKE :query")
    suspend fun searchInDB(query: String): List<SearchEntity>
}
