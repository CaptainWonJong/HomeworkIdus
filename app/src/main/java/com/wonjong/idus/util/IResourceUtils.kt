package com.wonjong.idus.util

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.wonjong.idus.IApplication


object IResourceUtils {

    fun getString(app: IApplication, @StringRes resId: Int): String {
        return app.getString(resId)
    }

    fun getColor(app: IApplication, @ColorRes resId: Int): Int {
        return ContextCompat.getColor(app, resId)
    }

    fun getDrawable(app: IApplication, @DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(app, resId)
    }
}
