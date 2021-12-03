package com.example.marvel.di


import com.example.marvel.data.remote.MarvelInterceptor
import com.example.marvel.data.remote.MarvelService
import com.example.marvel.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesMarvelService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): MarvelService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(MarvelService::class.java)
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: MarvelInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideInterceptor() = MarvelInterceptor()

    @Singleton
    @Provides
    fun provideLoginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()


}

