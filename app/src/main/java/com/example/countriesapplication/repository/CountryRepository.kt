package com.example.countriesapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.retrofit.CountriesApi
import javax.inject.Inject

/** Here dagger will check for CountriesApi since we are using constructor injection here
 * and Dagger will provide the object here automatically
 */
class CountryRepository @Inject constructor(private val countriesApi: CountriesApi)
{
    private val _countries = MutableLiveData<List<Country>>() // private member only
    val countries: LiveData<List<Country>> // public and read only.
    get() =_countries

    // suspend function to call the api
    suspend fun getCountries() {
        if (countriesApi.getCountries().body() != null)
            _countries.postValue(countriesApi.getCountries().body())
    }
}