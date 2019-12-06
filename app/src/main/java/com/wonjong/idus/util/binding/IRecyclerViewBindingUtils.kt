package com.wonjong.idus.util.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.base.holder.BaseViewHolder


/**
 * @author CaptainWonJong@gmail.com
 */

@BindingAdapter("bindScrollPosition")
fun RecyclerView.setBindScrollPosition(position: Int?) {
    if (position == null) {
        return
    }
    layoutManager?.scrollToPosition(position)
}

@BindingAdapter("setAdapter")
fun RecyclerView.setAdapter(adapter: RecyclerView.Adapter<BaseViewHolder<*>>) {
    this.adapter = adapter
}