package com.wonjong.idus.ui.model

import IHolderType
import com.wonjong.idus.ui.common.IViewHolderModel

data class ProductsListModel(
    val statusCode: Int,
    val body: List<ListBody>? = arrayListOf()
) : IViewHolderModel() {
    override val viewType = IHolderType.ProductsList
}


data class ListBody(
    val id: Int,
    val seller: String? = "",
    val thumbnail_520: String? = "",
    val title: String? = ""
)