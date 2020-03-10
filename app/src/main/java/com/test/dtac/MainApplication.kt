package com.test.dtac

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.test.di.appModule
import com.test.di.useCaseModule
import com.test.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(appModule, useCaseModule, viewModelModule))
        }
        FacebookSdk.sdkInitialize(this)
        AppEventsLogger.activateApp(this)
    }
}