package com.pixelarts.mvvm.ui

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pixelarts.mvvm.AppController
import com.pixelarts.mvvm.common.BOTTOM_SHEET
import com.pixelarts.mvvm.databinding.ActivityMainBinding
import com.pixelarts.mvvm.di.activity.ActivityComponent
import com.pixelarts.mvvm.di.activity.ActivityModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainBinding: ActivityMainBinding

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        mainBinding.setLifecycleOwner(this)
        mainBinding.viewModel = mainViewModel
        mainViewModel.getMedals().observe(this, Observer {
            recyclerView.apply {
                adapter = it
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })
    }

    fun addCountry(view: View){
        val fragment =  AddCountryDialogFragment()
        fragment.show(supportFragmentManager, BOTTOM_SHEET)
    }

    private fun injectDependencies(){
        activityComponent = (application as AppController).applicationComponent.newActivityComponent(
            ActivityModule(this)
        )
        activityComponent.inject(this)
    }
}
