package com.wonjong.idus.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.PagerSnapHelper
import com.wonjong.idus.base.BaseActivity
import com.wonjong.idus.databinding.ActivityProductDetailBinding
import com.wonjong.idus.ui.common.decoration.LinePagerIndicatorDecoration
import com.wonjong.idus.util.ERORR_INTEGER_ID
import com.wonjong.idus.util.INTENT_PRODUCT_DETAIL_ID
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.layout_contents_product_detail_thumbnail.*
import org.koin.androidx.viewmodel.ext.android.viewModel



/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailActivity : BaseActivity<ActivityProductDetailBinding, ProductDetailViewModel>() {

    override val layoutResId: Int
        get() = com.wonjong.idus.R.layout.activity_product_detail

    override val viewModel: ProductDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(com.wonjong.idus.R.anim.slide_in_top, com.wonjong.idus.R.anim.no_change)
        super.onCreate(savedInstanceState)
        binding.model = viewModel

        val productId = intent.getIntExtra(INTENT_PRODUCT_DETAIL_ID, ERORR_INTEGER_ID)
        if (productId > 0) {
            viewModel.requestProductDetail(productId)
        } else {
            Toast.makeText(this, com.wonjong.idus.R.string.error_detail_id, Toast.LENGTH_LONG).show()
            finish()
        }

        initViews()
    }

    override fun observeLiveData() {

    }

    override fun onCustomError(msg: String?) {  }

    private fun initViews() {
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_thumbnail_product_detail)

        val deco = LinePagerIndicatorDecoration(this)
        rv_thumbnail_product_detail.addItemDecoration(deco)

        // 굳이 SingleLiveData 쓰지 말자 별거 없는데
        iv_close.setOnClickListener {
            finish()
        }
    }
}