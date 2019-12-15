package com.wonjong.idus.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.net.response.ResponseProductDetail
import com.wonjong.idus.ui.adapter.ProductDetailAdapter
import com.wonjong.idus.ui.model.ProductDetailBodyModel
import com.wonjong.idus.ui.model.ProductDetailImageListModel
import com.wonjong.idus.util.extension.with

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailViewModel(private val repo: INetworkClient) : BaseViewModel(application = Application()) {

    var data = MutableLiveData<ArrayList<ProductDetailBodyModel>>()

    var seller = MutableLiveData<String?>()
    var title = MutableLiveData<String?>()
    var description = MutableLiveData<String?>()
    var cost = MutableLiveData<String?>()
    var discountCost = MutableLiveData<String?>()
    var discountRate = MutableLiveData<String?>()

    var imageUrlList = arrayListOf<ProductDetailImageListModel>()

    var productDetailAdapter = ProductDetailAdapter()

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