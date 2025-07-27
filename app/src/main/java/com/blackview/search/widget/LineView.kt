package com.blackview.search.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator

class LineView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val lines = mutableListOf<Line>()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 8f
        color = Color.GREEN
    }
    private val markPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 60f
        textAlign = Paint.Align.CENTER
        color = Color.GREEN
    }

    fun addLine(start: PointF, end: PointF) {
        lines.add(Line(start, end, 0f))
        startLineAnimation(lines.last())
    }

    private fun startLineAnimation(line: Line) {
        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener {
                line.progress = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        lines.forEach { line ->
            val endX = line.start.x + (line.end.x - line.start.x) * line.progress
            val endY = line.start.y + (line.end.y - line.start.y) * line.progress
            canvas.drawLine(line.start.x, line.start.y, endX, endY, paint)
        }
    }

    fun clearLines() {
        lines.clear()
        invalidate()
    }

    data class Line(
        val start: PointF,
        val end: PointF,
        var progress: Float
    )
}