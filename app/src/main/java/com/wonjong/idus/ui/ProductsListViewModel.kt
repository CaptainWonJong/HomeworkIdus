package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.ui.adapter.ProductsListAdapter
import com.wonjong.idus.ui.listener.OnProductsListRefreshListener
import com.wonjong.idus.ui.listener.OnProductsListScrollListener
import com.wonjong.idus.ui.model.ProductsListBodyModel
import com.wonjong.idus.util.extension.with

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductsListViewModel(private val repo: INetworkClient) : BaseViewModel(application = Application()) {

    private var _productsList = MutableLiveData<List<ProductsListBodyModel>>()
    val productsList: LiveData<List<ProductsListBodyModel>>
        get() = _productsList

    private var itemPageCount = 1

    var productsListAdapter = ProductsListAdapter()

    var onProductsListRefreshListener = OnProductsListRefreshListener()

    var onProductsListScrollListener = OnProductsListScrollListener()

    fun requestProductsList() {
        addDisposable(repo.getProductsList(itemPageCount).with()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({
                _productsList.value = it.body
                productsListAdapter.addItem(it.body)

                itemPageCount++
            }, {
                isError.value = Pair(true, null)
                ILog.e(it.message.toString())
            })
        )
    }
}