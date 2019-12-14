package com.wonjong.idus.ui

import android.os.Bundle
import android.widget.Toast
import com.wonjong.idus.base.BaseActivity
import com.wonjong.idus.databinding.ActivityProductDetailBinding
import com.wonjong.idus.util.ERORR_INTEGER_ID
import com.wonjong.idus.util.INTENT_PRODUCT_DETAIL_ID
import com.wonjong.idus.util.binding.setViewWidthRatio
import kotlinx.android.synthetic.main.layout_scrollable_product_detail.*
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
        rv_thumbnail_product_detail.setViewWidthRatio("1:1")
    }

    override fun observeLiveData() {

    }

    override fun onCustomError(msg: String?) {  }
}