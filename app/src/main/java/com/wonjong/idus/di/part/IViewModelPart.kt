package com.wonjong.idus.di.part

import com.wonjong.idus.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author CaptainWonJong@gmail.com
 */
val viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}
