package com.wonjong.idus.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.base.holder.BaseViewHolder
import com.wonjong.idus.ui.model.ProductDetailImageListModel

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailAdapter(
    private var item: ArrayList<ProductDetailImageListModel>? = arrayListOf()
) : RecyclerView.Adapter<BaseViewHolder<ProductDetailImageListModel>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ProductDetailImageListModel> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(com.wonjong.idus.R.layout.holder_item_product_detail, parent, false)
        return ProductDetailHolder(view)
    }

    override fun getItemCount(): Int = item?.size ?: 0

    override fun onBindViewHolder(holder: BaseViewHolder<ProductDetailImageListModel>, position: Int) {
        item?.get(position)?.let { holder.bind(it) }
    }

    fun addItem(item: List<ProductDetailImageListModel>?) {
        val beforeSize = itemCount
        item?.let { this.item?.addAll(it) }
        notifyItemRangeChanged(beforeSize, itemCount)
    }

    fun clearItem() {
        item?.clear()
        notifyDataSetChanged()
    }
}