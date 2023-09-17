package com.example.countriesapplication.di

import androidx.lifecycle.ViewModel
import com.example.countriesapplication.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun  mainViewModel(mainViewModel: MainViewModel): ViewModel
    // what this fun do is , it will bind the mainViewModel object with the  ViewModel
    // when ever there is a request for a viewModel it will return mainViewModel object.
}