package com.example.marvel.di

import com.example.marvel.BuildConfig.BASE_URL
import com.example.marvel.data.remote.AuthInterceptor
import com.example.marvel.data.remote.MarvelService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DependencyContainer {

    private val client = OkHttpClient
        .Builder()
        .addInterceptor(AuthInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: MarvelService = retrofit.create(MarvelService::class.java)

}