package com.example.marvel.di

import android.content.Context
import androidx.room.Room
import com.example.marvel.data.local.MarvelDatabase
import com.example.marvel.util.Constant

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

        @Singleton
        @Provides
        fun provideMarvelDatabase(
            @ApplicationContext context: Context
        ) = Room.databaseBuilder(context, MarvelDatabase::class.java, Constant.DATABASE_NAME).build()

}