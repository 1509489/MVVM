package com.pixelarts.mvvm.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixelarts.mvvm.R
import com.pixelarts.mvvm.databinding.AddCountryLayoutBinding
import com.pixelarts.mvvm.di.fragment.FragmentModule
import kotlinx.android.synthetic.main.add_country_layout.*
import javax.inject.Inject

class AddCountryDialogFragment: BottomSheetDialogFragment(){

    @Inject
    lateinit var addCountryViewModel : AddCountryViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependencies()
        setUpClickListeners()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding =  DataBindingUtil.inflate<AddCountryLayoutBinding>(inflater, R.layout.add_country_layout, container, false)
        return binding.root
    }

    fun injectDependencies(){
        (activity as MainActivity).activityComponent.newFragmentComponent(FragmentModule(this)).inject(this)
    }

    private fun setUpClickListeners()
    {
        btnSave.setOnClickListener{
            addCountryViewModel.insertCountry(
                etCountryName.text.toString(),
                etBronzeMedal.text.toString(),
                etSilverMedals.text.toString(),
                etGoldMedal.text.toString()
            )
            dismiss()
        }
    }
}