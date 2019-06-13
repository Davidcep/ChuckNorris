package com.example.chucknorris.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.chucknorris.Service.Model.Entity.Fact
import com.example.chucknorris.Service.Model.Repository.FactRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable


class FactViewModel : ViewModel() {

    private val factsLive = MutableLiveData<List<Fact>>()

    private fun getObserver(): SingleObserver<List<Fact>> {
        return object : SingleObserver<List<Fact>> {
            override fun onSuccess(t: List<Fact>) {
                Log.d("test", "Succes")
                factsLive?.postValue(t)
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("test", "Subscribe")
            }

            override fun onError(e: Throwable) {
                Log.d("test", "Error")
            }
        }
    }

    fun getFacts(): MutableLiveData<List<Fact>>? {
        var observer = getObserver()
        var observable = FactRepository.getObserver()
        observable
            .subscribe(observer)
        return factsLive
    }
}