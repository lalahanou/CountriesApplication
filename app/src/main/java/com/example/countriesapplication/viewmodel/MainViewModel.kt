package com.example.countriesapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.repository.CountryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * viewModel needs  repository class object to access the data from the model.
 * so we are passing that in the constructor itself
 */

class MainViewModel @Inject constructor(
    private val repository: CountryRepository,
) : ViewModel() {

    val countriesLiveData: LiveData<List<Country>>
        get() = repository.countries

    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        loading.value = true
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            repository.getCountries()
            loading.value = false
        }
    }

}
