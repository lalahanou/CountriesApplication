package com.example.countriesapplication.di

import com.example.countriesapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity) // for field inject property inside the MainActivity

}