package com.wonjong.idus.di.part

import com.google.gson.GsonBuilder
import com.wonjong.idus.util.myPrefixUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author CaptainWonJong@gmail.com
 */

const val CONNECT_TIMEOUT = 30L // 타임아웃 30초

val retrofitPart = module {
    single {
        Retrofit.Builder()
            .baseUrl(myPrefixUrl)
            .client(get())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        GsonBuilder().create()
    }

    single {
        OkHttpClient.Builder().run {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            build()
        }
    }

    // TODO: Header에 송수신 할 정보가 있다면 single로 Intercepter 추가 ...
}