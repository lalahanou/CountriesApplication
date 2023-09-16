package com.example.countriesapplication.di

import android.app.Application

class CountriesApplication : Application () {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}