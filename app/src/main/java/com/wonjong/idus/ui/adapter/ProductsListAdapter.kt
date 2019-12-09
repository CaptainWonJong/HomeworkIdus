package com.wonjong.idus.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.base.holder.BaseViewHolder
import com.wonjong.idus.ui.model.ProductsListBodyModel

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductsListAdapter(
    private var item: MutableList<ProductsListBodyModel>? = mutableListOf()
) : RecyclerView.Adapter<BaseViewHolder<ProductsListBodyModel>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductsListBodyModel> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(com.wonjong.idus.R.layout.holder_item_products, parent, false)
        return ProductsListHolder(view)
    }

    override fun getItemCount(): Int = item?.size ?: 0

    override fun onBindViewHolder(holder: BaseViewHolder<ProductsListBodyModel>, position: Int) {
        item?.get(position)?.let { holder.bind(it) }
    }

    fun addItem(item: List<ProductsListBodyModel>?) {
        item?.let { this.item?.addAll(it) }
        notifyDataSetChanged()
    }

    fun clear() {
        item?.clear()
        notifyDataSetChanged()
    }
}