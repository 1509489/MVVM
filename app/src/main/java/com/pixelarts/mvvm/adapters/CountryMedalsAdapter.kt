package com.pixelarts.mvvm.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixelarts.mvvm.R
import com.pixelarts.mvvm.data.entities.Country
import com.pixelarts.mvvm.databinding.RecyclerItemBinding

class CountryMedalsAdapter(val countryList: List<Country>):RecyclerView.Adapter<CountryMedalsAdapter.ViewHolder>(){
    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): CountryMedalsAdapter.ViewHolder {
        context = viewGroup.context
        val binding =  DataBindingUtil.inflate<RecyclerItemBinding>(LayoutInflater.from(context),R.layout.recycler_item, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val temp = countryList[position]
        holder.binding.apply {
            countryName.text = temp.countryName
            tvBronze.text = temp.bronzeMedals.toString()
            tvSilver.text = temp.silverMedals.toString()
            tvGold.text = temp.goldMedals.toString()
            tvTotal.text = "Total: ${temp.totalMedals}"
        }
    }

    class ViewHolder(var binding: RecyclerItemBinding):RecyclerView.ViewHolder(binding.root)

    interface OnItemClickedListener{
        fun onItemClicked(position: Int)
    }
}