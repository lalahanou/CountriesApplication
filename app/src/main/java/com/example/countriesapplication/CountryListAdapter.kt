package com.example.countriesapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesapplication.databinding.ItemCountryBinding
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.utils.getProgressDrawable
import com.example.countriesapplication.utils.loadImage

class CountryListAdapter(
    private var countries: ArrayList<Country>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }


    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
        holder.itemView.setOnClickListener { onClickListener.onClick(countries[position]) }
    }

    fun filterList(filterList: ArrayList<Country>) {
        countries = filterList
        notifyDataSetChanged()
    }

    class CountryViewHolder(private val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val progressDrawable = getProgressDrawable(binding.root.context)

        fun bind(country: Country) {
            binding.item = country
            binding.imageView.loadImage(country.flag, progressDrawable)
        }
    }
}

class OnClickListener(val clickListener: (country: Country) -> Unit) {
    fun onClick(country: Country) = clickListener(country)
}
