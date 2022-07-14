package com.aplikasi.listcharacter.di

import com.aplikasi.listcharacter.viewmodel.MainViewModel
import org.koin.dsl.module

val mainModule = module {
    factory { MainViewModel(get()) }
}