package com.blackview.search.core

import android.animation.ValueAnimator
import android.graphics.PointF
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.blackview.base.common.BaseViewModel
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.widget.LineView
import com.blackview.search.widget.ToggleImageView

abstract class BaseLineFragment<VM : BaseViewModel, DB : ViewBinding> :
    BaseVoiceAgainFragment<VM, DB>() {
    private val connectedPairs = mutableSetOf<Pair<Int, Int>>()

    private val replyTrue = listOf<Int>(
        R.raw.reply_true,
        R.raw.reply_true1,
        R.raw.reply_true2,
        R.raw.reply_true3,
        R.raw.reply_true4
    )
    private val replyFalse = listOf<Int>(
        R.raw.reply_false1,
        R.raw.reply_false2,
        R.raw.reply_false3,
        R.raw.reply_false4,
        R.raw.reply_false5,
        R.raw.reply_false6
    )
    private var failNum = 0
    var subject: SubjectBean? = null
    private var firstSelectedView: ImageView? = null
    private val scaleAnimator = ValueAnimator.ofFloat(1.0f, 1.2f).apply {
        duration = 200
        interpolator = OvershootInterpolator()
        addUpdateListener {
            val scale = it.animatedValue as Float
            firstSelectedView?.scaleX = scale
            firstSelectedView?.scaleY = scale
        }
    }
    private val resetAnimator = ValueAnimator.ofFloat(1.2f, 1.0f).apply {
        duration = 200
        interpolator = AccelerateDecelerateInterpolator()
        addUpdateListener {
            val scale = it.animatedValue as Float
            firstSelectedView?.scaleX = scale
            firstSelectedView?.scaleY = scale
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        subject = arguments?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
        getClickViews().forEach { imageView ->
            imageView.setOnClickListener { v ->
                handleClick(v as ImageView)
                true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        failNum = 0
        AudioPlayerManger.playRaw(getForewordRaw(), object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {

            }
        })
    }

    private fun handleClick(view: ImageView) {
        // 如果视图已连接，则忽略点击
        if (isViewConnected(view)) {
            return
        }

        // 如果没有已选择的视图
        if (firstSelectedView == null) {
            // 选择第一个视图
            firstSelectedView = view

            // 启动放大动画
            if (scaleAnimator.isRunning) scaleAnimator.cancel()
            scaleAnimator.start()

            return
        }

        // 如果点击的是同一个视图
        if (firstSelectedView == view) {
            // 启动缩小动画并取消选择
            resetSelectionWithAnimation()
            return
        }
        // 获取两个视图的ID
        val id1 = firstSelectedView!!.id
        val id2 = view.id

        // 检查是否是正确的配对
        val normalizedPair = if (id1 < id2) id1 to id2 else id2 to id1
        val isCorrect = getCorrectPairs().any {
            (it.first == id1 && it.second == id2) || (it.first == id2 && it.second == id1)
        }
        if (isCorrect) {
            drawConnection(firstSelectedView!!, view)
            connectedPairs.add(normalizedPair)
            // 检查是否所有配对都已完成
            if (connectedPairs.size == getCorrectPairs().size) {
                getLineView().postDelayed({
                    val stars = CommonUtils.parseStars(failNum)
                    val completeDialog = CompleteDialog(requireActivity(), subject?.id, stars) {
                        when (it) {
                            "retry" -> {
                                resetGame()
                                onResume()
                            }

                            "next" -> {
                                (activity as? StudyExerciseActivity)?.nextPage()
                            }

                            "update" -> {
                                updateStar(stars)
                            }
                        }
                    }
                    completeDialog.show()
                }, 1000)
            }
        } else {
            failNum++
        }
        AudioPlayerManger.playRaw(
            if (isCorrect) replyTrue.random() else replyFalse.random(),
            object : IPlayCallBack {
                override fun onStart(index: Int) {
                }

                override fun onEnd(index: Int) {
                }
            })
        // 重置选择（带动画）
        resetSelectionWithAnimation()
    }

    private fun isViewConnected(view: ImageView): Boolean {
        val viewId = view.id
        return connectedPairs.any { pair ->
            pair.first == viewId || pair.second == viewId
        }
    }

    private fun resetSelection() {
        firstSelectedView?.scaleX = 1.0f
        firstSelectedView?.scaleY = 1.0f
        firstSelectedView = null
    }

    private fun resetSelectionWithAnimation() {
        // 启动缩小动画
        if (resetAnimator.isRunning) resetAnimator.cancel()
        resetAnimator.start()

        // 延迟重置选择状态
        Handler(Looper.getMainLooper()).postDelayed({
            firstSelectedView = null
        }, 200)
    }

    private fun drawConnection(view1: ImageView, view2: ImageView) {
        val start = getCenter(view1)
        val end = getCenter(view2)
        getLineView().addLine(start, end)
    }

    private fun getCenter(view: View): PointF {
        return PointF(view.x + view.width / 2, view.y + view.height / 2)
    }

    private fun resetGame() {
        // 清除所有连线
        getLineView().clearLines()
        // 重置状态
        connectedPairs.clear()
        firstSelectedView = null

        // 重置所有ImageView的缩放
        resetAllImageViewsScale()
    }

    private fun resetAllImageViewsScale() {
        getClickViews().forEach { view ->
            view.scaleX = 1.0f
            view.scaleY = 1.0f
        }
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        onResume()
    }

    abstract fun getClickViews(): List<ImageView>
    abstract fun getLineView(): LineView
    abstract fun getForewordRaw(): Int
    abstract fun updateStar(star: Int)
    abstract fun getCorrectPairs(): List<Pair<Int, Int>>
}