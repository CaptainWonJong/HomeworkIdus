package com.wonjong.idus.ui.model

data class ProductsListModel(
    val statusCode: Int,
    val body: List<Body>? = arrayListOf()
)

data class Body(
    val id: Int,
    val seller: String? = "",
    val thumbnail_520: String? = "",
    val title: String? = ""
)