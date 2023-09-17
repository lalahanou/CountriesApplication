package com.example.countriesapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countriesapplication.di.CountriesApplication
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.viewmodel.MainViewModel
import com.example.countriesapplication.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.countriesList
import kotlinx.android.synthetic.main.activity_main.swipeRefreshLayout
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var countryList: ArrayList<Country>
   // private lateinit var countriesAdapter: CountryListAdapter



    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory // Dagger will provide the object to this variable through field injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as CountriesApplication).applicationComponent.inject(this)
        // what the above code do is, It will check the file for any of the @Inject property and if there are any
        // it will inject the correct object to them. Here it is mainViewModelFactory




        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        countryList = arrayListOf()

    }
}
