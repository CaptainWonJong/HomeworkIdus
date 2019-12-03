package com.wonjong.idus.ui.holder

import android.view.View
import com.wonjong.idus.ui.common.IViewHolder
import com.wonjong.idus.ui.model.ProductsListModel
import kotlinx.android.synthetic.main.holder_item_products.view.*


class ProductsListHolder(itemView: View) : IViewHolder<ProductsListModel>(itemView) {

    override fun bind(model: ProductsListModel) = with(itemView) {
        tv_title.text = "test"
        tv_seller.text = "test2"
    }
}
