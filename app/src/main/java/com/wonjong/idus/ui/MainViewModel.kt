package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.ui.model.ListBody
import com.wonjong.idus.util.MyEvent
import com.wonjong.idus.util.extension.with

/**
 * @author CaptainWonJong@gmail.com
 */
class MainViewModel(private val repo: INetworkClient) : BaseViewModel(application = Application()) {

    private var _productsList = MutableLiveData<List<ListBody>>()
    val productsList: LiveData<List<ListBody>>
        get() = _productsList

    private val _tabEvent = MutableLiveData<MyEvent<Int>>()
    val tabEvent: LiveData<MyEvent<Int>> = _tabEvent

    private var itemPageCount = 0

    fun requestProductsList() {
        addDisposable(repo.getProductsList(itemPageCount).with()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({
                _productsList.value = it.body
                itemPageCount++
            }, {
                ILog.e(it.message.toString())
            })
        )
    }
}