package com.wonjong.idus.ui.model

data class ProductsListModel(
    val statusCode: Int,
    val body: List<ListBody>? = arrayListOf()
)

data class ListBody(
    val id: Int,
    val seller: String? = "",
    val thumbnail_520: String? = "",
    val title: String? = ""
)