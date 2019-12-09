package com.wonjong.idus.base.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author CaptainWonJong@gmail.com
 */
// TODO: Android JetPack의 Compose 1.0 나오면 RecyclerView의 item으로 적용해보기!
// TODO: Declarative ui pattern을 지원하는 비슷한 라이브러리로 Epoxy(airbnb), litho(facebook)이 있음
abstract class BaseViewHolder<out T : IViewHolderModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: @UnsafeVariance T)
}
