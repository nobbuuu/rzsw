package com.blackview.search.view.fragment

import android.graphics.PointF
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseToyOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class ExerciseToyOneFragment :
    BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseToyOneBinding>() {
    private val activeTouches = mutableMapOf<Int, ImageView>()
    private val connections = mutableListOf<Pair<ImageView, ImageView>>()
    private val correctPairs = listOf(
        R.id.step1Iv to R.id.img3, // 示例正确组合
        R.id.step2Iv to R.id.img4,
        R.id.step3Iv to R.id.img1,
        R.id.step4Iv to R.id.img2
    )

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        val imageViews = listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv,mBinding.img1, mBinding.img2, mBinding.img3, mBinding.img4)

        imageViews.forEach { imageView ->
            imageView.setOnTouchListener { v, event ->
                handleTouch(v as ImageView, event)
                true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        AudioPlayerManger.playRaw(R.raw.l228dr, object : IPlayCallBack {
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
                checkConnections()
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                val pointerId = event.getPointerId(event.actionIndex)
                activeTouches.remove(pointerId)
            }
        }
    }

    private fun checkConnections() {
        if (activeTouches.size < 2) return

        val views = activeTouches.values.toSet()
        if (views.size == 2) {
            val pair = views.first() to views.last()
            if (!connections.contains(pair) && !connections.contains(pair.second to pair.first)) {
                connections.add(pair)
                drawConnection(pair.first, pair.second)
            }
        }
    }

    private fun drawConnection(view1: ImageView, view2: ImageView) {
        val start = getCenter(view1)
        val end = getCenter(view2)

        mBinding.lineView.addLine(start, end)

        // 检查是否完成所有连接
        if (connections.size == 2) {
            checkAnswers()
        }
    }

    private fun getCenter(view: View): PointF {
        return PointF(view.x + view.width / 2, view.y + view.height / 2)
    }

    private fun checkAnswers() {
        Handler(Looper.getMainLooper()).postDelayed({
            // 标记正确/错误
            connections.forEach { pair ->
                val isCorrect = correctPairs.any {
                    it == pair.first.id to pair.second.id ||
                            it == pair.second.id to pair.first.id
                }
                updateLineStatus(pair, isCorrect)
            }

            // 延迟后移除错误连线
            Handler(Looper.getMainLooper()).postDelayed({
                connections.clear()
                mBinding.lineView.removeWrongLines()
            }, 1500)
        }, 1000)
    }

    private fun updateLineStatus(pair: Pair<ImageView, ImageView>, isCorrect: Boolean) {
        val start = getCenter(pair.first)
        val end = getCenter(pair.second)

        mBinding.lineView.lines.firstOrNull { line ->
            line.start == start && line.end == end ||
                    line.start == end && line.end == start
        }?.isCorrect = isCorrect

        mBinding.lineView.invalidate()
    }
}