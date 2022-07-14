package com.aplikasi.listcharacter.service

import com.aplikasi.listcharacter.model.ListCharacter
import retrofit2.Response

class AppRepository(private val appInterface: AppInterface) {

    suspend fun listCharacter() : Response<ListCharacter> =
        appInterface.listCharacter()

}