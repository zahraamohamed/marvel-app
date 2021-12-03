package com.example.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "Marvel_Search")
data class SearchEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val description: String?,
    val imageUrl: String?,
)