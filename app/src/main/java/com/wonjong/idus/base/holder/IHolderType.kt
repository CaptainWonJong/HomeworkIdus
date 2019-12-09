package com.wonjong.idus.base.holder

import android.view.View
import androidx.annotation.LayoutRes
import com.wonjong.idus.R

/**
 * @author CaptainWonJong@gmail.com
 */
enum class IHolderType(@LayoutRes val layoutRes: Int, val creator: (View) -> BaseViewHolder<*>) {
    // RecyclerView 타입은 여기에 정리

    ProductsListType(R.layout.holder_item_products, {com.wonjong.idus.ui.adapter.ProductsListHolder(it)})
}
