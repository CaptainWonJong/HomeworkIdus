package com.wonjong.idus.di

import com.wonjong.idus.di.part.apiPart
import com.wonjong.idus.di.part.retrofitPart
import com.wonjong.idus.di.part.viewModelPart

/**
 * @author CaptainWonJong@gmail.com
 */
val IDiModule = listOf(
    retrofitPart,
    apiPart,
    viewModelPart
)
