package com.wonjong.idus.ui

import android.app.Application
import com.ctwj.mysampleapp.util.ILog
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.net.INetworkClient
import com.wonjong.idus.util.extension.with

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailViewModel(private val repo: INetworkClient) : BaseViewModel(application = Application()) {

    fun requestProductDetail(productId: Int) {
        addDisposable(repo.getProductDetail(productId).with()
            .doOnSubscribe { isLoading.value = true }
            .doOnSuccess { isLoading.value = false }
            .doOnError { isLoading.value = false }
            .subscribe({
                ILog.e("${it.body}")
            }, {
                ILog.e(it.message.toString())
            })
        )
    }
}