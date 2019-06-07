package com.example.chucknorris.Retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
object Client {

    //Lazy nos ejecutará el lambda la primera vez que lo llamemos y las siguientes llamadas devolverá
    //el valor creado anteriormente
    val getFacts: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}