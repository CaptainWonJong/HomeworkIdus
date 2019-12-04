package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun onTabClickEvent(eventType: Int) {
        _tabEvent.value = MyEvent(eventType)

        addDisposable(repo.getProductsList(1).with()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({
                _productsList.value = it.body
            }, {

            }))
    }
}