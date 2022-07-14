package com.aplikasi.listcharacter.di

import com.aplikasi.listcharacter.service.AppInterface
import com.aplikasi.listcharacter.service.AppRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val appRepoModule = module {
    factory { AppRepository(get<Retrofit>(named(appService)).create(AppInterface::class.java)) }
}