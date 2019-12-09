package com.wonjong.idus.ui

import android.content.Intent
import android.os.Bundle
import com.wonjong.idus.R
import com.wonjong.idus.base.BaseActivity
import com.wonjong.idus.databinding.ActivityMainBinding
import com.wonjong.idus.util.INTENT_PRODUCT_DETAIL_ID
import com.wonjong.idus.util.bus.RxBus
import com.wonjong.idus.util.enum.EventType
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author CaptainWonJong@gmail.com
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.model = getViewModel()

        receiveRxBus()

        viewModel.requestProductsList()
    }

    override fun observeLiveData() {

    }

    override fun onCustomError(msg: String?) {  }

    private fun receiveRxBus() {
        viewModel.addDisposable(RxBus.subject.subscribe {
            if ((it as Pair<EventType, Int>).first == EventType.MAIN_LIST_ITEM_CLICK) {
                // https://developer.android.com/training/transitions/start-activity 굳이 이렇게 처리해야 할 필요가 있을까?
                val intent = Intent(this, ProductDetailActivity::class.java)
                intent.putExtra(INTENT_PRODUCT_DETAIL_ID, it.second)
                startActivity(intent)
            }
        })
    }
}