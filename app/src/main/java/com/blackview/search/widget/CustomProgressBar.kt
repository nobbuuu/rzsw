package com.blackview.search.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ProgressBar
import com.blackview.search.R

class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.progressBarStyleHorizontal
) : ProgressBar(context, attrs, defStyleAttr) {

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rect = RectF()
    private var cornerRadius = 0f

    init {
        context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar).apply {
            bgPaint.color = getColor(R.styleable.CustomProgressBar_backgroundColor, Color.LTGRAY)
            progressPaint.color = getColor(R.styleable.CustomProgressBar_progressColor, Color.BLUE)
            cornerRadius = getDimension(R.styleable.CustomProgressBar_cornerRadius, 10f)
            recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        rect.set(0f, 0f, width.toFloat(), height.toFloat())
        
        // 绘制背景
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, bgPaint)
        
        // 绘制进度
        if (progress > 0) {
            val progressWidth = (width * progress / max.toFloat()).toFloat()
            rect.set(0f, 0f, progressWidth, height.toFloat())
            canvas.drawRoundRect(rect, cornerRadius, cornerRadius, progressPaint)
        }
    }
}