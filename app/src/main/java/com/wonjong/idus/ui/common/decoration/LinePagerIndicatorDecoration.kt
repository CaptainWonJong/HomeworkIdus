package com.wonjong.idus.ui.common.decoration

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wonjong.idus.R

class LinePagerIndicatorDecoration(private val context: Context) : RecyclerView.ItemDecoration() {
    private val colorActive : Int by lazy {
        ContextCompat.getColor(context, R.color.white_00)
    }
    private val colorInactive : Int by lazy {
        ContextCompat.getColor(context, R.color.dart_navy_blue)
    }

    private val dp = Resources.getSystem().displayMetrics.density

    private val indicatorHorizontalPadding = dp * 1
    private val indicatorVerticalPadding = dp * 4
    private val indicatorTotalWidth = dp * 360
    private val indicatorItemStrokeWidth = dp * 5
    private val indicatorHeight = (dp * 45).toInt()
    private val indicatorStrokeWidth = indicatorItemStrokeWidth + indicatorVerticalPadding
    private var indicatorItemLength = 0f

    private val interpolator = AccelerateDecelerateInterpolator()
    private val paint = Paint()

    init {
        paint.strokeCap = Paint.Cap.ROUND
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val itemCount = parent.adapter?.itemCount ?: 0
        indicatorItemLength = indicatorTotalWidth / itemCount
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f
        val indicatorPosY = parent.height - indicatorHeight / 2f

        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount)

        val layoutManager = parent.layoutManager as LinearLayoutManager
        val activePosition = layoutManager.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        val activeChild = layoutManager.findViewByPosition(activePosition)
        val left = activeChild?.left ?: 0
        val width = activeChild?.width ?: 0
        val progress = interpolator.getInterpolation(left * -1 / width.toFloat())

        drawHighlights(c, indicatorStartX, indicatorPosY, activePosition, progress, itemCount)
    }

    private fun drawInactiveIndicators(
        c: Canvas,
        indicatorStartX: Float,
        indicatorPosY: Float,
        itemCount: Int
    ) {
        paint.color = colorInactive
        paint.strokeWidth = indicatorStrokeWidth

        var startX = indicatorStartX - indicatorHorizontalPadding
        val stopX = indicatorStartX + indicatorItemLength * itemCount

        c.drawLine(startX, indicatorPosY, stopX, indicatorPosY, paint)
    }

    private fun drawHighlights(
        c: Canvas, indicatorStartX: Float, indicatorPosY: Float,
        highlightPosition: Int, progress: Float, itemCount: Int
    ) {
        paint.color = colorActive
        paint.strokeWidth = indicatorItemStrokeWidth

        if (progress == 0f) {
            val highlightStart = indicatorStartX + indicatorItemLength * highlightPosition
            c.drawLine(
                indicatorStartX, indicatorPosY,
                highlightStart + indicatorItemLength, indicatorPosY, paint
            )
        } else {
            var highlightStart = indicatorStartX + indicatorItemLength * highlightPosition
            val partialLength = indicatorItemLength * progress

            c.drawLine(
                indicatorStartX, indicatorPosY,
                highlightStart + indicatorItemLength, indicatorPosY, paint
            )

            if (highlightPosition < itemCount - 1) {
                highlightStart += indicatorItemLength
                c.drawLine(
                    highlightStart, indicatorPosY,
                    highlightStart + partialLength, indicatorPosY, paint
                )
            }
        }
    }
}
