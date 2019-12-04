package com.wonjong.idus.ui.model

import com.google.gson.annotations.SerializedName

/**
 * @author CaptainWonJong@gmail.com
 */
data class ProductsListModel(
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("body") val body: List<ListBody>? = arrayListOf()
)

data class ListBody(
    @SerializedName("id") val id: Int,
    @SerializedName("seller") val seller: String? = "",
    @SerializedName("thumbnail_520") val thumbnail_520: String? = "",
    @SerializedName("title") val title: String? = ""
)