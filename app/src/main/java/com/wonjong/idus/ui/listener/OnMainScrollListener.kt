package com.wonjong.idus.ui.listener

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author CaptainWonJong@gmail.com
 */
class OnMainScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = GridLayoutManager::class.java.cast(recyclerView.layoutManager)
        val totalItemCount = layoutManager?.itemCount ?: 0
        val lastVisible = layoutManager?.findLastCompletelyVisibleItemPosition() ?: 0

        if (lastVisible >= totalItemCount - 1) {
            Log.d("asdasd", "lastVisibled")
        }
    }
}