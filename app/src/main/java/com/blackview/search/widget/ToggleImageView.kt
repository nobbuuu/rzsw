package com.blackview.search.widget

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.blackview.search.R

class ToggleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isDrag = false

    init {

        inflate(context, R.layout.view_toggle, this)
        val styles = context.obtainStyledAttributes(attrs, R.styleable.toggleView)
        val imgRes = styles.getResourceId(R.styleable.toggleView_srcImg, 0)
        findViewById<ImageView>(R.id.originBgIv).setImageResource(imgRes)
        isDrag = styles.getBoolean(R.styleable.toggleView_isDrag, false)
        val toggleGravity = styles.getInt(R.styleable.toggleView_toggleGravity, 4)
        // 获取边距设置
        val toggleMargin = styles.getDimensionPixelSize(R.styleable.toggleView_toggleMargin, 0)
        post {
            val toggleIv = findViewById<ImageView>(R.id.toggleIv)
            val params = toggleIv.layoutParams as ConstraintLayout.LayoutParams
            params.removeConstraints()
            when (toggleGravity) {
                0 -> {
                    params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    params.setMargins(0, toggleMargin, 0, 0)
                }

                1 -> {
                    params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    params.setMargins(toggleMargin, 0, 0, 0)
                }

                2 -> {
                    params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    params.setMargins(0, 0, toggleMargin, 0)
                    params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                }

                3 -> {
                    params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    params.setMargins(0, 0, 0, toggleMargin)
                }

                4 -> {
                    params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                }
            }
            toggleIv.layoutParams = params
        }
        styles.recycle()
    }

    private var lastX = 0f
    private var lastY = 0f
    private var dX = 0f
    private var dY = 0f

    // 初始位置偏移量
    private var initialTranslationX = 0f
    private var initialTranslationY = 0f

    // 拖动状态跟踪
    private var isDragged = false

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        // 保存初始位置
        initialTranslationX = translationX
        initialTranslationY = translationY
    }

    fun ConstraintLayout.LayoutParams.removeConstraints() {
        startToStart = ConstraintLayout.LayoutParams.UNSET
        startToEnd = ConstraintLayout.LayoutParams.UNSET
        endToStart = ConstraintLayout.LayoutParams.UNSET
        endToEnd = ConstraintLayout.LayoutParams.UNSET
        topToTop = ConstraintLayout.LayoutParams.UNSET
        topToBottom = ConstraintLayout.LayoutParams.UNSET
        bottomToTop = ConstraintLayout.LayoutParams.UNSET
        bottomToBottom = ConstraintLayout.LayoutParams.UNSET
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (isDrag) {
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
                    isDragged = true
                    return true
                }

                MotionEvent.ACTION_UP -> {
                    // 可选：添加释放动画效果
                    performClick()
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    // 重置到初始位置
    fun resetPosition() {
        animate().translationX(initialTranslationX)
            .translationY(initialTranslationY)
            .setDuration(300)
            .setInterpolator(android.view.animation.AccelerateDecelerateInterpolator())
            .start()
        isDragged = false
    }

    // 检查是否被拖动过
    fun wasDragged(): Boolean = isDragged

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