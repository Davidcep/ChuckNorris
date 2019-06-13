package com.example.chucknorris.Retrofit

import com.example.chucknorris.Data.Fact
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiFacts {
    @get:GET("jokes/random")
    val facts: Observable<Fact>
}