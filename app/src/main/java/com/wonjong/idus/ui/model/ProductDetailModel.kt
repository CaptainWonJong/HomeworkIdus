package com.wonjong.idus.ui.model

import com.google.gson.annotations.SerializedName
import com.wonjong.idus.base.holder.IHolderType
import com.wonjong.idus.base.holder.IViewHolderModel
import com.wonjong.idus.ui.model.base.BaseModel

/**
 * @author CaptainWonJong@gmail.com
 */
data class ProductDetailModel(
    @SerializedName("statusCode")
    override val statusCode: Int,

    @SerializedName("body")
    val body: ArrayList<ProductDetailBodyModel>? = arrayListOf()
) : BaseModel()

data class ProductDetailBodyModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("cost")
    val cost: String? = "",

    @SerializedName("description")
    val description: String? = "",

    @SerializedName("discount_cost")
    val discount_cost: String? = "",

    @SerializedName("discount_rate")
    val discount_rate: String? = "",

    @SerializedName("seller")
    val seller: String? = "",

    @SerializedName("thumbnail_720")
    val thumbnail_720: String? = "",

    @SerializedName("thumbnail_list_320")
    val thumbnail_list_320: String? = "",

    @SerializedName("title")
    val title: String? = ""
)

data class ProductDetailImageListModel(
    var imageUrl: String? = ""
) : IViewHolderModel() {
    override val viewType = IHolderType.ProductDetailType
}