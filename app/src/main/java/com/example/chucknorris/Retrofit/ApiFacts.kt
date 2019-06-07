package com.example.chucknorris.Retrofit

import com.example.chucknorris.Model.Fact
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiFacts {
    @get:GET("jokes/random")
    val facts: Observable<Fact>
}