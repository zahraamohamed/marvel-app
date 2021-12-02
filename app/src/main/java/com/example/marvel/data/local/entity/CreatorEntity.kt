package com.example.marvel.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Marvel_Creator")
data class CreatorEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
)