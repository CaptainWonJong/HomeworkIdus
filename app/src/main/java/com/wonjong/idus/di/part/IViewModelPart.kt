package com.wonjong.idus.di.part

import com.wonjong.idus.ui.ProductsListViewModel
import com.wonjong.idus.ui.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author CaptainWonJong@gmail.com
 */
val viewModelPart = module {
    viewModel { ProductsListViewModel(get()) }
    viewModel { ProductDetailViewModel(get()) }
}
