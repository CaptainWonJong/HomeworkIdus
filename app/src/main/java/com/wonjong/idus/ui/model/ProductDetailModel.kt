package com.wonjong.idus.ui.model

data class ProductDetailModel(
    val statusCode: Int,
    val body: ArrayList<DetailBody>? = arrayListOf()
)

data class DetailBody(
    val id: Int,
    val cost: String? = "",
    val description: String? = "",
    val discount_cost: String? = "",
    val discount_rate: String? = "",
    val seller: String? = "",
    val thumbnail_720: String? = "",
    val thumbnail_list_320: String? = "",
    val title: String? = ""
)