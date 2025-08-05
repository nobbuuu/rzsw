package com.blackview.search.core

import android.graphics.PointF
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
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
    private val activeTouches = mutableMapOf<Int, ImageView>()

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

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        subject = arguments?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
        getToggleViews().forEach { imageView ->
            imageView.setOnTouchListener { v, event ->
                handleTouch(v as ImageView, event)
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

    private fun handleTouch(view: ImageView, event: MotionEvent) {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val pointerId = event.getPointerId(event.actionIndex)
                activeTouches[pointerId] = view
                checkConnection()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                val pointerId = event.getPointerId(event.actionIndex)
                activeTouches.remove(pointerId)
            }
        }
    }

    private fun checkConnection() {
        if (activeTouches.size < 2) return

        val views = activeTouches.values.toSet()
        if (views.size == 2) {
            val view1 = views.first()
            val view2 = views.last()
            val id1 = view1.id
            val id2 = view2.id
            // 检查是否是正确的配对
            val normalizedPair = if (id1 < id2) id1 to id2 else id2 to id1
            val correctPairs = getCorrectPairs()
            val isCorrect = correctPairs.any {
                (it.first == id1 && it.second == id2) || (it.first == id2 && it.second == id1)
            }
            if (isCorrect) {
                drawConnection(view1, view2)
                connectedPairs.add(normalizedPair)
                // 检查是否所有配对都已完成
                if (connectedPairs.size == correctPairs.size) {
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

            // 清空当前触摸，准备下一次连接
            activeTouches.clear()
        }
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
        activeTouches.clear()
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        onResume()
    }

    abstract fun getToggleViews(): List<ToggleImageView>
    abstract fun getLineView(): LineView
    abstract fun getForewordRaw(): Int
    abstract fun updateStar(star: Int)
    abstract fun getCorrectPairs(): List<Pair<Int, Int>>
}