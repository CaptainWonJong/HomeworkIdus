package com.wonjong.idus.base.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author CaptainWonJong@gmail.com
 */
abstract class BaseViewHolder<out T : IViewHolderModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: @UnsafeVariance T)
}
