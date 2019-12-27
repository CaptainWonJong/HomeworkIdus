package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.response.ResponseProductsList
import com.wonjong.idus.ui.adapter.ProductsListAdapter
import com.wonjong.idus.ui.listener.OnProductsListRefreshListener
import com.wonjong.idus.ui.listener.OnProductsListScrollListener
import com.wonjong.idus.ui.model.ProductsListBodyModel
import com.wonjong.idus.util.enum.RequestType
import com.wonjong.idus.util.extension.with
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductsListViewModel(private val repo: INetworkClient) :
    BaseViewModel(application = Application()), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job + handler

    var productsList: MutableLiveData<ArrayList<ProductsListBodyModel>>? = MutableLiveData()

    private val INIT_PAGE = 1

    private var itemPageCount = INIT_PAGE

    var productsListAdapter = ProductsListAdapter()

    var onProductsListRefreshListener = OnProductsListRefreshListener(this)

    var onProductsListScrollListener = OnProductsListScrollListener(this)

    fun requestProductsListToCoroutine(type: RequestType) {
        CoroutineScope(coroutineContext).launch {
            productsList?.value = repo.getProductsListToCoroutine(itemPageCount).await().body
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
        requestProductsList(RequestType.REQUEST_MAIN_LIST_REFRESH)
    }
}