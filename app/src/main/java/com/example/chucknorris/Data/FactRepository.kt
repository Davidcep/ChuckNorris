package com.example.chucknorris.Data

import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.chucknorris.Retrofit.ApiFacts
import com.example.chucknorris.Retrofit.Client
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import kotlin.concurrent.thread

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