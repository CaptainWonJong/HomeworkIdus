package com.wonjong.idus.ui.listener

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.base.BaseViewModel
import com.wonjong.idus.ui.ProductsListViewModel
import com.wonjong.idus.util.enum.RequestType

/**
 * @author CaptainWonJong@gmail.com
 */
class OnProductsListScrollListener(var viewModel: BaseViewModel) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = GridLayoutManager::class.java.cast(recyclerView.layoutManager)
        val totalItemCount = layoutManager?.itemCount ?: 0
        val lastVisible = layoutManager?.findLastCompletelyVisibleItemPosition() ?: 0

        if (lastVisible >= totalItemCount - 1) {
            when(viewModel) {
                is ProductsListViewModel -> {
                    (viewModel as ProductsListViewModel).requestProductsListToCoroutine(RequestType.REQUEST_MAIN_LIST_LOAD_MORE)
                }
            }
        }
    }
}