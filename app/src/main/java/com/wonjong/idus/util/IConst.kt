package com.wonjong.idus.util

import com.wonjong.idus.BuildConfig

/**
 * @author CaptainWonJong@gmail.com
 */

private const val mockPrefixUrl = "https://2jt4kq01ij.execute-api.ap-northeast-2.amazonaws.com/prod/"
private const val prodPrefixUrl = "https://2jt4kq01ij.execute-api.ap-northeast-2.amazonaws.com/prod/"

val myPrefixUrl get() = if (isProd()) {
    prodPrefixUrl
} else mockPrefixUrl

fun isProd() : Boolean {
    return BuildConfig.FLAVOR == "prod"
}

// Intent
const val INTENT_PRODUCT_DETAIL_ID = "intentProductDetailId"

// Constants
const val ERORR_INTEGER_ID = -1
const val ERORR_STRING_ID = ""

