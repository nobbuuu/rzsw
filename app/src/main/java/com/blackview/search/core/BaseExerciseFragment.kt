package com.blackview.search.core

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.blackview.base.common.BaseViewModel
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.Step
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.widget.ToggleImageView
import kotlin.collections.forEach

abstract class BaseExerciseFragment<VM : BaseViewModel, DB : ViewBinding> :
    BaseVoiceAgainFragment<VM, DB>() {
    private var currentStep = 0
    private var isAcceptingInput = false
    private val clickAbleViews: MutableList<ToggleImageView> = mutableListOf()
    private var failNum = 0
    var subject: SubjectBean? = null
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
    private val steps = mutableListOf<Step>()
    private val handleClick = View.OnClickListener { v ->
        when (v) {
            clickAbleViews[0] -> {
                checkAnswer("step1", v)
            }

            clickAbleViews[1] -> {
                checkAnswer("step2", v)
            }

            clickAbleViews[2] -> {
                checkAnswer("step3", v)
            }

            clickAbleViews[3] -> {
                checkAnswer("step4", v)
            }
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        subject = arguments?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
    }

    private fun startStep(stepIndex: Int) {
        clickAbleViews.forEach {
            it.isShowToggleIv(false)
        }
        if (stepIndex >= steps.size) {
            val stars = CommonUtils.parseStars(failNum)
            val completeDialog = CompleteDialog(requireActivity(), subject?.id, stars) {
                when (it) {
                    "retry" -> {
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
            return
        }

        val step = steps[stepIndex]
        AudioPlayerManger.playRaw(step.audioResId, object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {
                isAcceptingInput = true
            }
        })
    }

    private fun checkAnswer(selectedOrgan: String, toggleView: View) {
        if (!isAcceptingInput) return
        isAcceptingInput = false
        var curStep = steps[currentStep]
        val isCorrect = selectedOrgan == curStep.correctOrgan
        val checkIv = toggleView as ToggleImageView
        checkIv.setToggleImage(isCorrect)
        AudioPlayerManger.playRaw(
            if (isCorrect) replyTrue.random() else replyFalse.random(),
            object : IPlayCallBack {
                override fun onStart(index: Int) {
                }

                override fun onEnd(index: Int) {
                    onCorrect(isCorrect, selectedOrgan)
                    if (!isCorrect){
                        toggleView.resetPosition()
                    }
                    if (isCorrect) {
                        currentStep++
                        startStep(currentStep)
                    } else {

                        startStep(currentStep)
                    }
                }
            })
    }

    override fun onResume() {
        super.onResume()
        clickAbleViews.clear()
        steps.clear()
        currentStep = 0
        failNum = 0
        clickAbleViews.addAll(getToggleViews())
        getContentRaw().forEach {
            steps.add(Step(it, "step${steps.size + 1}", null))
        }
        clickAbleViews.forEach {
            it.setOnClickListener(handleClick)
            it.isShowToggleIv(false)
            it.resetPosition()
        }
        AudioPlayerManger.playRaw(getForewordRaw(), object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {
                startStep(currentStep)
            }
        })
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        startStep(currentStep)
    }

    abstract fun getToggleViews(): List<ToggleImageView>
    abstract fun getForewordRaw(): Int
    abstract fun getContentRaw(): IntArray
    abstract fun updateStar(star: Int)
    open fun onCorrect(isCorrect: Boolean, step: String) {}
}