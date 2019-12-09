package com.wonjong.idus.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.wonjong.idus.R

/**
 * @author CaptainWonJong@gmail.com
 */

@BindingAdapter("setImageUri")
fun ImageView.setImageUri(uri: String?) {
    Glide.with(context)
        .load(uri)
        .placeholder(R.drawable.ic_block_grey_600_24dp)
        .error(R.drawable.ic_block_grey_600_24dp)
        .into(this)
}

@BindingAdapter("setRoundCornerImageUri", "setRoundCornerImageRadius")
fun ImageView.setRoundCornerImageUri(uri: String?, radius: Int?) {
    Glide.with(context)
        .load(uri)
        .placeholder(R.drawable.ic_block_grey_600_24dp)
        .error(R.drawable.ic_block_grey_600_24dp)
        .transform(CenterInside(), RoundedCorners(radius ?: 0))
        .into(this)
}