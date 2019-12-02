package com.wonjong.idus.net

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface INetworkClient {

    // 리스트를 가져온다.
    @GET("products?page={pageNo}")
    fun getProducts(@Path("pageNo") pageNo: Int): Single<ResponseBody>

    // 상세 정보를 가져온다.
    @GET("products/{productNo}")
    fun getProductDetail(@Path("productNo") productNo: Int): Single<ResponseBody>
}