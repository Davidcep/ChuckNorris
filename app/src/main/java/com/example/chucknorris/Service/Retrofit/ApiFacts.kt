package com.example.chucknorris.Service.Retrofit

import com.example.chucknorris.Service.Model.Entity.Fact
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiFacts {
    @get:GET("jokes/random")
    val facts: Observable<Fact>
}