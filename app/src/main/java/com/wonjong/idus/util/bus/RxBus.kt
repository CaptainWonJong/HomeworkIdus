package com.wonjong.idus.util.bus

import com.ctwj.mysampleapp.util.ILog
import io.reactivex.subjects.PublishSubject

/**
 * @author CaptainWonJong@gmail.com
 */
object RxBus {

    val subject = PublishSubject.create<Any>()

    fun sendEvent(item: Any) {
        subject.onNext(item)
    }

    private fun onError() {
        subject.doOnError { ILog.e(it.toString()) }
    }
}