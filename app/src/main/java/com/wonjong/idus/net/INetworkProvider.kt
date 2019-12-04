package com.wonjong.idus.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author CaptainWonJong@gmail.com
 */
fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .run {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        build()
}