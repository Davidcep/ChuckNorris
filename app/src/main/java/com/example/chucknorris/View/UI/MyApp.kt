package com.example.chucknorris.View.UI

import android.app.Application
import com.example.chucknorris.Service.Injector.DaggerNetworkComponent
import com.example.chucknorris.Service.Injector.NetworkComponent

class MyApp: Application() {

    companion object {
        lateinit var instance: MyApp
            private set
    }

    lateinit var appComponent: NetworkComponent
        private set


    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {

        appComponent = DaggerNetworkComponent.builder()
            .build()
        appComponent.inject(this)
    }

}