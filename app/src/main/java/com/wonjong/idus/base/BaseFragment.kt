package com.wonjong.idus.base

import com.ctwj.mysampleapp.util.enum.ViewAnimType
import leakcanary.AppWatcher

/**
 * @author CaptainWonJong@gmail.com
 */
abstract class BaseFragment : androidx.fragment.app.Fragment() {

    open fun getViewAnimation(): ViewAnimType {
        return ViewAnimType.NONE
    }

    open fun getToken(): String {
        return javaClass.name
    }

    open fun reset() {

    }

    override fun onDestroy() {
        super.onDestroy()
        AppWatcher.objectWatcher.watch(this)
    }
}