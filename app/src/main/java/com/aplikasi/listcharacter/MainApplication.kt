package com.aplikasi.listcharacter

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.aplikasi.listcharacter.di.appRepoModule
import com.aplikasi.listcharacter.di.mainModule
import com.aplikasi.listcharacter.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        startKoin {

            androidContext(this@MainApplication)

            modules(
                    networkModule,
                    appRepoModule,
                    mainModule
            )
        }
    }

    companion object {
        private lateinit var context: Context

        fun getContext(): Context {
            return context
        }
    }
}