package com.aplikasi.listcharacter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplikasi.listcharacter.model.ListCharacter
import com.aplikasi.listcharacter.service.AppRepository
import com.aplikasi.listcharacter.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.net.HttpURLConnection

class MainViewModel(private val appRepository: AppRepository): ViewModel() {

    val loadingEvent = SingleLiveEvent<Boolean>()
    val listEvent = SingleLiveEvent<ListCharacter>()
    val errorEvent = SingleLiveEvent<String>()

    fun getData(){
        loadingEvent.value = true

        lateinit var response: Response<ListCharacter>

        viewModelScope.launch {
            with(Dispatchers.IO){
                response = appRepository.listCharacter()
            }

            with(Dispatchers.Main){
                try{
                    if (HttpURLConnection.HTTP_OK == response.code()){
                        listEvent.value = response.body()
                    }else{
                        Log.e("Main VM", "Terjadi Kesalahan : "+response.code())
                        errorEvent.value = response.code().toString()
                    }

                }catch (ex: Exception){
                    errorEvent.value = ex.localizedMessage
                    Log.e("Main", "Ex : "+ex.localizedMessage)
                }finally {
                    loadingEvent.value = false
                }
            }
        }
    }
}