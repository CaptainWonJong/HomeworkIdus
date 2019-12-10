package com.wonjong.idus.ui.model

import com.google.gson.annotations.SerializedName
import com.wonjong.idus.ui.model.base.BaseModel

/**
 * @author CaptainWonJong@gmail.com
 */
data class ProductDetailModel(
    @SerializedName("statusCode")
    override val statusCode: Int,

    @SerializedName("body")
    val body: ArrayList<DetailBody>? = arrayListOf()
) : BaseModel()

data class DetailBody(
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