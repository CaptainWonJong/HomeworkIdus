package com.wonjong.idus.util

import com.wonjong.idus.BuildConfig


private const val mockPrefixUrl = "https://2jt4kq01ij.execute-api.ap-northeast-2.amazonaws.com/prod/"
private const val prodPrefixUrl = "https://2jt4kq01ij.execute-api.ap-northeast-2.amazonaws.com/prod/"

val myPrefixUrl get() = if (isProd()) {
    prodPrefixUrl
} else mockPrefixUrl

fun isProd() : Boolean {
    return BuildConfig.FLAVOR == "prod"
}