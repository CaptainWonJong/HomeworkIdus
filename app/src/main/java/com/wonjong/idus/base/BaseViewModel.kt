package com.wonjong.idus.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ctwj.mysampleapp.util.ILog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob

/**
 * @author CaptainWonJong@gmail.com
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private var compositeDisposable = CompositeDisposable()

    var isLoading = MutableLiveData<Boolean>()

    var isError = MutableLiveData<Pair<Boolean, String?>>(Pair(false, null))

    val job = SupervisorJob()
    val handler = CoroutineExceptionHandler { _, e ->
        isError.value = Pair(true, null)
        ILog.e(e.toString())
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun removeDisposable(disposable: Disposable): Boolean {
        return compositeDisposable.remove(disposable)
    }

    fun clearDisposables() {
        compositeDisposable.clear()
    }

    fun clearJob() {
        job.cancel()
    }
}