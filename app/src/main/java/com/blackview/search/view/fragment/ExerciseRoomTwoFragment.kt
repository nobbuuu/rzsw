package com.blackview.search.view.fragment

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseRoomTwoBinding
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseRoomTwoFragment :
    BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseRoomTwoBinding>() {

    private val activeTouches = mutableMapOf<Int, ToggleImageView>()

    // 使用ID定义正确配对
    private val correctPairs = listOf(
        R.id.step1Iv to R.id.step2Iv,
        R.id.step4Iv to R.id.step5Iv,
        R.id.step6Iv to R.id.step8Iv
    )
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
        val imageViews = listOf(
            mBinding.step1Iv,
            mBinding.step2Iv,
            mBinding.step3Iv,
            mBinding.step4Iv,
            mBinding.step5Iv,
            mBinding.step6Iv,
            mBinding.step7Iv,
            mBinding.step8Iv
        )
        imageViews.forEach { imageView ->
            imageView.setOnTouchListener { v, event ->
                handleTouch(v as ToggleImageView, event)
                true
            }
        }
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        onResume()
    }

    override fun onResume() {
        super.onResume()
        failNum = 0
        AudioPlayerManger.playRaw(R.raw.l238dr, object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {

            }
        })
    }

    private fun handleTouch(view: ToggleImageView, event: MotionEvent) {
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
            val isCorrect = correctPairs.any {
                (it.first == id1 && it.second == id2) || (it.first == id2 && it.second == id1)
            }
            view1.setToggleImage(isCorrect)
            view2.setToggleImage(isCorrect)
            if (isCorrect) {
                connectedPairs.add(normalizedPair)
                // 检查是否所有配对都已完成
                if (connectedPairs.size == correctPairs.size) {
                    mBinding.step1Iv.postDelayed({
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
                                    viewModel.update(stars, subject?.id.toString())
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

    private fun resetGame() {
        // 重置状态
        connectedPairs.clear()
        activeTouches.clear()
    }
}