package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.response.ResponseProductsList
import com.wonjong.idus.ui.adapter.ProductsListAdapter
import com.wonjong.idus.ui.listener.OnProductsListRefreshListener
import com.wonjong.idus.ui.listener.OnProductsListScrollListener
import com.wonjong.idus.ui.model.ProductsListBodyModel
import com.wonjong.idus.ui.model.ProductsListModel
import com.wonjong.idus.util.enum.RequestType
import com.wonjong.idus.util.extension.with
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductsListViewModel(private val repo: INetworkClient) :
    BaseViewModel(application = Application()) {

    var productsList: MutableLiveData<ArrayList<ProductsListBodyModel>>? = MutableLiveData()

    private val INIT_PAGE = 1

    private var itemPageCount = INIT_PAGE

    var productsListAdapter = ProductsListAdapter()

    var onProductsListRefreshListener = OnProductsListRefreshListener(this)

    var onProductsListScrollListener = OnProductsListScrollListener(this)

    private val job = SupervisorJob()
    private val handler = CoroutineExceptionHandler { _, e -> ILog.e(e.toString()) }

    fun requestProductsListToCoroutine(type: RequestType) {
        viewModelScope.launch(Dispatchers.Main) {

            when (type) {
                RequestType.REQUEST_MAIN_LIST_INIT -> {
                    isLoading.value = true
                }
                RequestType.REQUEST_MAIN_LIST_LOAD_MORE -> {
                }
                RequestType.REQUEST_MAIN_LIST_REFRESH -> {
                }
            }

            var data = ProductsListModel(0)
            viewModelScope.launch(Dispatchers.IO + job + handler) {
                data = repo.getProductsListToCoroutine(itemPageCount).await()
            }

            ResponseProductsList(this@ProductsListViewModel, data)
            onProductsListRefreshListener.isRefresh.value = false
            itemPageCount++
        }
    }

    fun requestProductsList(type: RequestType) {
        addDisposable(repo.getProductsList(itemPageCount).with()
            .doOnSubscribe {
                when (type) {
                    RequestType.REQUEST_MAIN_LIST_INIT -> {
                        isLoading.value = true
                    }
                    RequestType.REQUEST_MAIN_LIST_LOAD_MORE -> {

                    }
                    RequestType.REQUEST_MAIN_LIST_REFRESH -> {

                    }
                }
            }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({ model ->
                ResponseProductsList(this, model)
                onProductsListRefreshListener.isRefresh.value = false

                itemPageCount++

            }, {
                isError.value = Pair(true, null)
                ILog.e(it.message.toString())

            })
        )
    }

    fun initItemPage() {
        itemPageCount = INIT_PAGE
    }

    fun requestRefreshProductsList() {
        initItemPage()
        productsListAdapter.clearItem()
        requestProductsListToCoroutine(RequestType.REQUEST_MAIN_LIST_REFRESH)
    }
}