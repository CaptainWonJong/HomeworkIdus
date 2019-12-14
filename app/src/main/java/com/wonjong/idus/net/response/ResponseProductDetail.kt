package com.wonjong.idus.net.response

import com.wonjong.idus.net.response.base.BaseResponse
import com.wonjong.idus.ui.ProductDetailViewModel
import com.wonjong.idus.ui.model.ProductDetailModel

/**
 * @author CaptainWonJong@gmail.com
 */
class ResponseProductDetail(var viewModel: ProductDetailViewModel, model: ProductDetailModel) :
    BaseResponse<ProductDetailModel>() {

    override var model = model
    private val DEFAULT_NUM = 0

    init {
        checkModel()
    }

    override fun onSuccess() : Unit = with(viewModel) {
        val data  = model.body
        data?.let {
            seller.value = it[DEFAULT_NUM].seller
            title.value = it[DEFAULT_NUM].title
            cost.value = it[DEFAULT_NUM].cost
            description.value = it[DEFAULT_NUM].description
            discountCost.value = it[DEFAULT_NUM].discount_cost
            discountRate.value = it[DEFAULT_NUM].discount_rate
        }
    }

    override fun onFail() {
        viewModel.isError.value = Pair(true, null)
    }
}