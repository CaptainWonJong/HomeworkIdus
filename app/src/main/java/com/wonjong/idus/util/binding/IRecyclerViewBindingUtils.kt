package com.wonjong.idus.util.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.base.holder.BaseViewHolder
import com.wonjong.idus.ui.model.ProductsListBodyModel


/**
 * @author CaptainWonJong@gmail.com
 */
@BindingAdapter("setAdapter")
fun setProductsListAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<BaseViewHolder<ProductsListBodyModel>>) {
    view.adapter = adapter
}

@BindingAdapter("addOnScrollListener")
fun addOnScrollListener(view: RecyclerView, onScrollListener: RecyclerView.OnScrollListener) {
    view.addOnScrollListener(onScrollListener)
}