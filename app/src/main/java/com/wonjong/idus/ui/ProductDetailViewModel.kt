package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.response.ResponseProductDetail
import com.wonjong.idus.ui.model.DetailBody
import com.wonjong.idus.util.extension.with

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailViewModel(private val repo: INetworkClient) : BaseViewModel(application = Application()) {

    var data = MutableLiveData<ArrayList<DetailBody>>()

    var seller = MutableLiveData<String?>()
    var title = MutableLiveData<String?>()
    var description = MutableLiveData<String?>()
    var cost = MutableLiveData<String?>()
    var discountCost = MutableLiveData<String?>()
    var discountRate = MutableLiveData<String?>()

    fun requestProductDetail(productId: Int) {
        addDisposable(repo.getProductDetail(productId).with()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({model ->
                ResponseProductDetail(this, model)

            }, {
                ILog.e(it.message.toString())
            })
        )
    }
}