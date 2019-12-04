package com.wonjong.idus.di

import com.google.gson.GsonBuilder
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.provideOkHttpClient
import com.wonjong.idus.ui.MainViewModel
import com.wonjong.idus.util.myPrefixUrl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author CaptainWonJong@gmail.com
 */
val retrofitPart = module {
    single {
        Retrofit.Builder()
            .baseUrl(myPrefixUrl)
            .client(provideOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        GsonBuilder().create()
    }
}

val viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

val apiPart = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(INetworkClient::class.java)
    }
}

val IDiModule = listOf(
    retrofitPart,
    apiPart,
    viewModelPart
)
