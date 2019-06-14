package com.example.chucknorris.Service.Injector

import com.example.chucknorris.View.UI.MainActivity
import com.example.chucknorris.View.UI.MyApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(myApp: MyApp){
    }
}
