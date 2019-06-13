package com.example.chucknorris.Service.Model.Repository

import com.example.chucknorris.Service.Model.Entity.Fact
import com.example.chucknorris.Service.Retrofit.ApiFacts
import com.example.chucknorris.Service.Retrofit.Client
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class FactRepository {

    companion object{

        fun getObserver(): Single<List<Fact>> {
            //Init API
            var retro: Retrofit = Client.getFacts
            var factApi: ApiFacts = retro.create(ApiFacts::class.java)

            val toList = Observable
                .range(0, 20)
                .flatMap {
                    factApi.facts
                }
                .subscribeOn(Schedulers.io())
                .toList()
                .map { it.toList() }


            return toList
        }
    }
}