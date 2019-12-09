package com.wonjong.idus.ui.listener

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author CaptainWonJong@gmail.com
 */
class OnProductsListScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = GridLayoutManager::class.java.cast(recyclerView.layoutManager)
        val totalItemCount = layoutManager?.itemCount ?: 0
        val lastVisible = layoutManager?.findLastCompletelyVisibleItemPosition() ?: 0

        if (lastVisible >= totalItemCount - 1) {
            // TODO: 아래 새로고침 만들어야함
        }
    }
}