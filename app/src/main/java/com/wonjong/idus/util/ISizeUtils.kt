package com.wonjong.idus.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager


/**
 * @author CaptainWonJong@gmail.com
 */
object ISizeUtils {

    fun getDisplaySize(context: Context): Point {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }
}
