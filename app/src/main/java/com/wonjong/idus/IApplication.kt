package com.wonjong.idus

import android.app.Application
import com.wonjong.idus.di.IDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author CaptainWonJong@gmail.com
 */
class IApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@IApplication)
            modules(IDiModule)
        }
    }
}