package com.wonjong.idus.util.binding

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter


/**
 * @author CaptainWonJong@gmail.com
 */
@BindingAdapter("isStrikeThrough")
fun TextView.isStrikeThrough(cancel: Boolean) {
    paintFlags = if (cancel) {
        Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        0
    }
}