package com.wonjong.idus.util.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


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
