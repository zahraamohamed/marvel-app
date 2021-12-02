package com.example.marvel.data.remote

import com.example.marvel.BuildConfig
import com.example.marvel.util.md5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val apiKey = BuildConfig.PUBLIC_KEY
        val hash = "$timestamp${BuildConfig.PRIVATE_KEY}$apiKey".md5()

        with(chain.request()) {
            url.newBuilder().apply {
                addQueryParameter(API_KEY_PARAM, apiKey)
                addQueryParameter(TIMESTAMP_PARAM, timestamp)
                addQueryParameter(HASH_PARAM, hash)
            }.build().also {
                return chain.proceed(this.newBuilder().url(it).build())
            }
        }
    }

    companion object {
        private const val API_KEY_PARAM = "apikey"
        private const val TIMESTAMP_PARAM = "ts"
        private const val HASH_PARAM = "hash"
    }
}
