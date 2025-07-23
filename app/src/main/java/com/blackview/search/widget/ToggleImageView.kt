package com.blackview.search.widget

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.blackview.base.kt.ktAnimScale
import com.blackview.search.R

class ToggleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {

        inflate(context, R.layout.view_toggle, this)
        val styles = context.obtainStyledAttributes(attrs, R.styleable.toggleView)
        val imgRes = styles.getResourceId(R.styleable.toggleView_srcImg, 0)
        findViewById<ImageView>(R.id.originBgIv).setImageResource(imgRes)
        styles.recycle()
    }

    private var lastX = 0f
    private var lastY = 0f
    private var dX = 0f
    private var dY = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // 记录初始触摸位置和当前偏移量
                lastX = event.rawX
                lastY = event.rawY
                dX = translationX
                dY = translationY
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                // 计算手指移动的偏移量
                val deltaX = event.rawX - lastX
                val deltaY = event.rawY - lastY

                // 计算新的偏移量（带边界检查）
                val newX = (dX + deltaX).coerceIn(
                    -left.toFloat(),
                    (parent as View).width - right.toFloat()
                )

                val newY = (dY + deltaY).coerceIn(
                    -top.toFloat(),
                    (parent as View).height - bottom.toFloat()
                )

                // 应用新的偏移量
                translationX = newX
                translationY = newY
                return true
            }
            MotionEvent.ACTION_UP -> {
                // 可选：添加释放动画效果
                performClick()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    fun setToggleImage(isRight: Boolean) {
        val toggleIv = findViewById<ImageView>(R.id.toggleIv)
        toggleIv.isVisible = true
        if (isRight) {
            toggleIv.setImageDrawable(context.getDrawable(R.drawable.anim_choose_correct))
        } else {
            toggleIv.setImageDrawable(context.getDrawable(R.drawable.anim_choose_mistake))
        }
        val anim = toggleIv.drawable as AnimationDrawable
        toggleIv.post {
            anim.start()
        }
    }

    fun isShowToggleIv(visible: Boolean) {
        findViewById<ImageView>(R.id.toggleIv).isVisible = visible
    }

    fun getSrcIv(): ImageView {
        return findViewById(R.id.originBgIv)
    }
}