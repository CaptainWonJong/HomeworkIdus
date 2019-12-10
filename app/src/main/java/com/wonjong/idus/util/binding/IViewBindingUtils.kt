package com.wonjong.idus.util.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.wonjong.idus.util.listener.OnDebounceClickListener

/**
 * @author CaptainWonJong@gmail.com
 */

@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("onDebounceClick")
fun View.setOnDebounceClickListener(listener: View.OnClickListener?) {
    if (listener != null) {
        setOnClickListener(OnDebounceClickListener(listener))
    }
}
