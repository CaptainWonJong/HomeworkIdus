package com.wonjong.idus.ui

import android.os.Bundle
import android.widget.Toast
import com.wonjong.idus.R
import com.wonjong.idus.base.BaseActivity
import com.wonjong.idus.databinding.ActivityProductDetailBinding
import com.wonjong.idus.util.ERORR_INTEGER_ID
import com.wonjong.idus.util.INTENT_PRODUCT_DETAIL_ID
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author CaptainWonJong@gmail.com
 */
class ProductDetailActivity : BaseActivity<ActivityProductDetailBinding, ProductDetailViewModel>() {

    override val layoutResId: Int
        get() = R.layout.activity_product_detail

    override val viewModel: ProductDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_top, R.anim.no_change)
        super.onCreate(savedInstanceState)
        binding.model = viewModel

        val productId = intent.getIntExtra(INTENT_PRODUCT_DETAIL_ID, ERORR_INTEGER_ID)
        if (productId > 0) {
            viewModel.requestProductDetail(productId)
        } else {
            Toast.makeText(this, R.string.error_detail_id, Toast.LENGTH_LONG).show()
            finish()
        }
    }
    override fun observeLiveData() {

    }

    override fun onCustomError(msg: String?) {  }
}