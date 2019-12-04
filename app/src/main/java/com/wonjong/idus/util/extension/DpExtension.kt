package com.wonjong.idus.util.extension

import android.util.DisplayMetrics
import com.wonjong.idus.IApplication
import kotlin.math.roundToInt

/**
 * @author CaptainWonJong@gmail.com
 */

val Int.dp: Int
    get() {
        return floatDp.roundToInt()
    }

val Float.dp: Int
    get() {
        return floatDp.roundToInt()
    }


val Int.floatDp: Float
    get() {
        val metrics = IApplication().resources.displayMetrics
        return (this * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
    }

val Float.floatDp: Float
    get() {
        val metrics = IApplication().resources.displayMetrics
        return (this * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
    }
