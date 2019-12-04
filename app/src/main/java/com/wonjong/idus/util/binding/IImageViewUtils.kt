package com.wonjong.idus.util.binding

import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.databinding.BindingAdapter
import com.wonjong.idus.util.extension.floatDp

/**
 * @author CaptainWonJong@gmail.com
 */

@BindingAdapter("roundingDp")
fun View.setRoundingView(radius: Int){
    background = GradientDrawable().apply {
        cornerRadius = radius.floatDp
    }
}