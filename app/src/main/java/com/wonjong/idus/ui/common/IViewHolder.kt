package com.wonjong.idus.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class IViewHolder<out T : IViewHolderModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: @UnsafeVariance T)
}

