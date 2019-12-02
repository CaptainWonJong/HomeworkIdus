package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.ui.model.ProductsListModel
import com.wonjong.idus.util.MyEvent

class MainViewModel : BaseViewModel(application = Application()) {

    private var _imageList = MutableLiveData<ProductsListModel>()
    val imageList: LiveData<ProductsListModel>
        get() = _imageList


    private val _tabEvent = MutableLiveData<MyEvent<Int>>()
    val tabEvent: LiveData<MyEvent<Int>> = _tabEvent

    fun onTabClickEvent(eventType: Int) {
        _tabEvent.value = MyEvent(eventType)
    }
}