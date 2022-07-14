package com.aplikasi.listcharacter.di

import com.aplikasi.listcharacter.service.AppService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named(appService)){AppService.getServices()}
}

const val appService = "APP_SERVICE"