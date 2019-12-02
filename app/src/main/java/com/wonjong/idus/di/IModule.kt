package com.wonjong.idus.di

import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.provideOkHttpClient
import com.wonjong.idus.ui.MainViewModel
import com.wonjong.idus.util.myPrefixUrl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var retrofitPart = module {
    single {
        Retrofit.Builder()
            .baseUrl(myPrefixUrl)
            .client(provideOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(INetworkClient::class.java)

    }
}

var viewModelPart = module {
    viewModel { MainViewModel() }
}

var MyDiModule = listOf(
    retrofitPart,
    viewModelPart
)
