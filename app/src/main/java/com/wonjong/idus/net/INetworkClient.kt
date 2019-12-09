package com.wonjong.idus.net

import com.wonjong.idus.ui.model.ProductDetailModel
import com.wonjong.idus.ui.model.ProductsListModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author CaptainWonJong@gmail.com
 */
interface INetworkClient {

    // 리스트를 가져온다.
    @GET("products")
    fun getProductsList(@Query("page") page: Int): Single<ProductsListModel>

    // 상세 정보를 가져온다.
    @GET("products/{productNo}")
    fun getProductDetail(@Path("productNo") productNo: Int): Single<ProductDetailModel>
}