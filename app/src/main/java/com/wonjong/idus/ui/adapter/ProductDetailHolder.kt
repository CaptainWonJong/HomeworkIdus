package com.wonjong.idus.ui.adapter

import android.view.View
import com.wonjong.idus.base.holder.BaseViewHolder
import com.wonjong.idus.ui.model.ProductDetailImageListModel
import com.wonjong.idus.util.binding.setImageUri
import kotlinx.android.synthetic.main.holder_item_product_detail.view.*

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailHolder(itemView: View) : BaseViewHolder<ProductDetailImageListModel>(itemView) {

    override fun bind(model: ProductDetailImageListModel) = with(model) {
        itemView.iv_thumbnail.setImageUri(imageUrl)
    }
}