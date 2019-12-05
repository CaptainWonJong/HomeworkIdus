package com.wonjong.idus.ui.model

import com.google.gson.annotations.SerializedName
import com.wonjong.idus.base.holder.IHolderType
import com.wonjong.idus.base.holder.IViewHolderModel

/**
 * @author CaptainWonJong@gmail.com
 */
data class ProductsListModel(
    @SerializedName("statusCode")
    val statusCode: Int,

    @SerializedName("body")
    val body: List<ListBody>? = arrayListOf()
) : IViewHolderModel() {
    override val viewType = IHolderType.ProductsListType
}

data class ListBody(
    @SerializedName("id")
    val id: Int,

    @SerializedName("seller")
    val seller: String? = "",

    @SerializedName("thumbnail_520")
    val thumbnail_520: String? = "",

    @SerializedName("title")
    val title: String? = ""
)