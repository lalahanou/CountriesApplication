package com.example.countriesapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.repository.CountryRepository
import kotlinx.coroutines.launch

/**
 * viewModel needs  repository class object to access the data from the model.
 * so we are passing that in the constructor itself
 */

class MainViewModel(private val repository: CountryRepository) : ViewModel() {

    val countriesLiveData: LiveData<List<Country>>
        get() =repository.countries

    // inti method will call right after the viewModel is created .
    // so all the codes inside the init method will be executed first
    init {
        // this is the coroutine that we use to connenct the api.
        viewModelScope.launch {
            repository.getCountries()
        }
    }
}