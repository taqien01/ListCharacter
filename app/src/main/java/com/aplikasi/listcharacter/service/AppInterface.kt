package com.aplikasi.listcharacter.service

import com.aplikasi.listcharacter.model.ListCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppInterface {

    @GET("character")
    suspend fun listCharacter(): Response<ListCharacter>

}