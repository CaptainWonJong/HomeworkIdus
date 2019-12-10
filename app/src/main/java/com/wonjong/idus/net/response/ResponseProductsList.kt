package com.wonjong.idus.net.response

import com.wonjong.idus.net.response.base.BaseResponse
import com.wonjong.idus.ui.ProductsListViewModel
import com.wonjong.idus.ui.model.ProductsListModel

/**
 * @author CaptainWonJong@gmail.com
 */
class ResponseProductsList(var viewModel: ProductsListViewModel, model: ProductsListModel) :
    BaseResponse<ProductsListModel>() {

    override var model = model

    init {
        checkModel()
    }

    override fun onSuccess() : Unit = with(viewModel) {
        val list  = model.body
        list?.let {
            productsList?.value?.addAll(it)
            productsListAdapter.addItem(it)
        }
    }

    override fun onFail() {
        viewModel.isError.value = Pair(true, null)
    }
}