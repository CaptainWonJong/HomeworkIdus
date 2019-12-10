package com.wonjong.idus.net.response.base

import com.wonjong.idus.ui.model.base.BaseModel
import com.wonjong.idus.util.RESPONSE_CODE_200
import com.wonjong.idus.util.RESPONSE_CODE_400
import com.wonjong.idus.util.RESPONSE_CODE_404
import com.wonjong.idus.util.RESPONSE_CODE_500

/**
 * @author CaptainWonJong@gmail.com
 */
abstract class BaseResponse<M : BaseModel> {

    open lateinit var model: M

    fun checkModel() {
        model?.let {
            when (it.statusCode) {
                RESPONSE_CODE_200 -> {
                    onSuccess()
                }
                RESPONSE_CODE_400, RESPONSE_CODE_404, RESPONSE_CODE_500 -> {
                    onFail()
                }
            }
        }
    }

    abstract fun onSuccess()

    abstract fun onFail()
}