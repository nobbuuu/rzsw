package com.blackview.search.core

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

class MultiTouchHelper() {
    // 用 Map 记录每个 View 的按压状态
    private val pressedStates = mutableMapOf<View, Boolean>()
    private val views: MutableList<View> = mutableListOf()
    private var view1: View? = null
    private var view2: View? = null
    private var clickViews = mutableListOf<View>()
    private var onRightClick: ((Boolean) -> Unit)? = null

    // 统一的触摸监听器
    @SuppressLint("ClickableViewAccessibility")
    private val handleTouch = View.OnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                pressedStates[v] = true
                onBothViewTouch()
                onViewClick()
                true
            }

            MotionEvent.ACTION_UP -> {
                pressedStates[v] = false
                onBothViewTouch()
                onViewClick()
                true
            }

            else -> false
        }
    }

    private val handleClick = View.OnClickListener { v ->
        views.forEach {
            if (it != v) {
                pressedStates[it] = false
            } else {
                pressedStates[v] = true
            }
        }
        onViewClick()
    }

    init {
        // 初始化所有 View 的按压状态为 false
        views.forEach { view ->
            pressedStates[view] = false
            view.setOnTouchListener(handleTouch)
        }
    }

    // 检测所有 View 是否全部被按住
    private fun onBothViewTouch() {
        if (views.contains(view1) && views.contains(view2)) {
            val isBothClick = pressedStates[view1] == true && pressedStates[view2] == true
            onRightClick?.invoke(isBothClick)
        }
    }

    private fun onViewClick() {
        if (views.containsAll(clickViews)) {
            clickViews.forEach {
                pressedStates[it] == true
            }
            val isClick = pressedStates[clickViews.random()] == true
            onRightClick?.invoke(isClick)
        }
    }

    // 可选：动态添加/移除 View
    fun addView(view: View): MultiTouchHelper {
        if (!views.contains(view)) {
            pressedStates[view] = false
            view.setOnTouchListener(handleTouch)
        }
        return this
    }

    // 可选：动态添加/移除 View
    fun initTouchViews(pageViews: List<View>): MultiTouchHelper {
        views.clear()
        views.addAll(pageViews)
        views.forEach {
            pressedStates[it] = false
            it.setOnTouchListener(handleTouch)
        }
        return this
    }

    fun initClickViews(
        pageViews: List<View>,
    ): MultiTouchHelper {
        views.clear()
        views.addAll(pageViews)
        views.forEach {
            pressedStates[it] = false
            it.setOnClickListener(handleClick)
        }
        return this
    }

    fun checkBothViewClick(
        view1: View,
        view2: View,
        onBothClick: ((Boolean)) -> Unit
    ): MultiTouchHelper {
        this.view1 = view1
        this.view2 = view2
        this.onRightClick = onBothClick
        return this
    }

    fun checkViewClick(
        vararg views: View,
        onRightClick: ((Boolean)) -> Unit
    ): MultiTouchHelper {
        clickViews.clear()
        clickViews.addAll(views)
        this.onRightClick = onRightClick
        return this
    }
}