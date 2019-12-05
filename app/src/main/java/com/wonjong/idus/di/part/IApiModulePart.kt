package com.wonjong.idus.di.part

import com.wonjong.idus.net.INetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * @author CaptainWonJong@gmail.com
 */
val apiPart = module {
    single(createdAtStart = false) {
        get<Retrofit>().create(INetworkClient::class.java)
    }
}