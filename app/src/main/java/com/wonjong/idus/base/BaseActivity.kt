package com.wonjong.idus.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.wonjong.idus.R

/**
 * @author CaptainWonJong@gmail.com
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    lateinit var binding: B

    abstract val viewModel: VM

    abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this

        observeLiveData()
        onError()
    }

    abstract fun observeLiveData()

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposables()
    }

    private fun onError() {
        viewModel.isError.observe(this, Observer {
            if (it.first) {
                if (it.second.isNullOrEmpty()) {
                    onDefaultError()
                } else onCustomError(it.second)

            } else return@Observer
        })
    }

    abstract fun onCustomError(msg: String?)

    private fun onDefaultError() {
        Toast.makeText(this, R.string.error_default_msg, Toast.LENGTH_LONG).show()
    }
}