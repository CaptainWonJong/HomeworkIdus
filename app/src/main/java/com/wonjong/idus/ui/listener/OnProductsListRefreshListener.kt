package com.wonjong.idus.ui.listener

import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.ui.ProductsListViewModel

/**
 * @author CaptainWonJong@gmail.com
 */
class OnProductsListRefreshListener(var viewModel: BaseViewModel) : SwipeRefreshLayout.OnRefreshListener {

    var isRefresh = MutableLiveData<Boolean>(false)

    override fun onRefresh() {
        when(viewModel) {
            is ProductsListViewModel -> {
                (viewModel as ProductsListViewModel).requestRefreshProductsList()
            }
        }
    }
}