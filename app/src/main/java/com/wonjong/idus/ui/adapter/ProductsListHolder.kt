package com.wonjong.idus.ui.adapter

import android.view.View
import com.wonjong.idus.base.holder.BaseViewHolder
import com.wonjong.idus.ui.model.ProductsListBodyModel
import com.wonjong.idus.util.binding.setRoundCornerImageUri
import com.wonjong.idus.util.bus.RxBus
import com.wonjong.idus.util.enum.EventType
import com.wonjong.idus.util.extension.dp
import kotlinx.android.synthetic.main.holder_item_products.view.*

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductsListHolder(itemView: View) : BaseViewHolder<ProductsListBodyModel>(itemView) {

    override fun bind(model: ProductsListBodyModel) = with(model) {
        itemView.tv_title.text = title
        itemView.tv_seller.text = seller
        itemView.iv_thumbnail.setRoundCornerImageUri(thumbnail_520, 4.dp) // 굳이 상수 안빼도 될듯
        itemView.cl_container.setOnClickListener {
            RxBus.sendEvent(Pair(EventType.MAIN_LIST_ITEM_CLICK, id))
        }
    }
}