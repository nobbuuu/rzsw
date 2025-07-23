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
    internal val lines = mutableListOf<Line>()
    private val correctLines = mutableListOf<Line>()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 8f
        color = Color.BLUE
    }
    private val markPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 60f
        textAlign = Paint.Align.CENTER
    }

    fun addLine(start: PointF, end: PointF, isCorrect: Boolean? = null) {
        lines.add(Line(start, end, 0f, isCorrect))
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
        // 绘制连线
        lines.forEach { line ->
            val endX = line.start.x + (line.end.x - line.start.x) * line.progress
            val endY = line.start.y + (line.end.y - line.start.y) * line.progress
            
            paint.color = when {
                line.isCorrect == true -> Color.GREEN
                line.isCorrect == false -> Color.RED
                else -> Color.BLUE
            }
            
            canvas.drawLine(line.start.x, line.start.y, endX, endY, paint)
            
            // 绘制标记
            if (line.progress == 1f && line.isCorrect != null) {
                val centerX = (line.start.x + line.end.x) / 2
                val centerY = (line.start.y + line.end.y) / 2
                
                markPaint.color = if (line.isCorrect == true) Color.GREEN else Color.RED
                canvas.drawText(
                    if (line.isCorrect == true) "✓" else "○",
                    centerX, 
                    centerY + 20, 
                    markPaint
                )
            }
        }
    }

    fun removeWrongLines() {
        val wrongLines = lines.filter { it.isCorrect == false }
        lines.removeAll(wrongLines)
        invalidate()
    }

    data class Line(
        val start: PointF,
        val end: PointF,
        var progress: Float,
        var isCorrect: Boolean? = null
    )
}