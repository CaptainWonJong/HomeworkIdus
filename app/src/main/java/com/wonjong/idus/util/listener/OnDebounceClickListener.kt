package com.wonjong.idus.util.listener

import android.view.View


/**
 * @author CaptainWonJong@gmail.com
 */

class OnDebounceClickListener(private val listener: View.OnClickListener?) : View.OnClickListener {

    private val INTERVAL = 500L

    override fun onClick(v: View?) {
        val now = System.currentTimeMillis()
        if (now < recentTime + INTERVAL) return
        recentTime = now
        v?.run { listener }
    }

    companion object {
        private var recentTime = 0L
    }
}
