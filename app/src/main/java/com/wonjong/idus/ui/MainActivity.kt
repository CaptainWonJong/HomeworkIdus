package com.wonjong.idus.ui

import android.os.Bundle
import android.widget.Toast
import com.wonjong.idus.R
import com.wonjong.idus.base.BaseActivity
import com.wonjong.idus.databinding.ActivityMainBinding
import com.wonjong.idus.util.MyEventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.model = viewModel

    }

    override fun observeLiveData() {
        viewModel.tabEvent.observe(this, MyEventObserver { event ->
            Toast.makeText(baseContext, "event : ${event}", Toast.LENGTH_LONG).show()
        })
    }
}