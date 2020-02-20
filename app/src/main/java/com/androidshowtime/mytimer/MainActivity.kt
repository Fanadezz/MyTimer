package com.androidshowtime.mytimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidshowtime.mytimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModelMain::class.java)

        /*set the viewModel for Data Binding - this allows the bound layout access
               all the data in the ViewModel so as the layout can communicate directly
               to the viewModel*/

        binding.viewModelMain = viewModel as ViewModelMain


        /* specify the activity as the lifecycle owner for the binding. This
         is used so that the binding can observe LiveData*/

        binding.lifecycleOwner = this

    }
}
