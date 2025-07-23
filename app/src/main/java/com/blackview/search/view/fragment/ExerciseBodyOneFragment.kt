package com.blackview.search.view.fragment

import android.os.Bundle
import android.view.View
import com.blackview.search.R
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.kt.ktAnimScale
import com.blackview.search.bean.Step
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseBodyOneBinding
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBodyOneFragment :
    BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseBodyOneBinding>() {
    private var currentStep = 0
    private var failNum = 0
    private var isAcceptingInput = false
    private val clickAbleViews: MutableList<ToggleImageView> = mutableListOf()
    private var subject: SubjectBean? = null
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
        when (v.id) {
            R.id.mouthIv -> {
                checkAnswer("mouth", v)
            }

            R.id.eye1Iv, R.id.eye2Iv -> {
                checkAnswer("eyes", v)
            }

            R.id.noseIv -> {
                checkAnswer("nose", v)
            }

            R.id.ear1Iv, R.id.ear2Iv -> {
                checkAnswer("ears", v)
            }
        }
    }

    private fun startStep(stepIndex: Int) {
        clickAbleViews.forEach {
            it.isShowToggleIv(false)
        }
        if (stepIndex >= steps.size) {
            val stars = CommonUtils.parseStars(failNum)
            subject?.let {
                viewModel.update(stars, it.id.toString())
                val completeDialog = CompleteDialog(requireActivity(), it.id, stars) {
                    when (it) {
                        "retry" -> {
                            onResume()
                        }

                        "next" -> {
                            (activity as? StudyExerciseActivity)?.nextPage()
                        }
                    }
                }
                completeDialog.show()
            }
            return
        }

        val step = steps[stepIndex]
        step.targetImage?.ktAnimScale(step.audioResId) {
            isAcceptingInput = true
        }
    }

    private fun checkAnswer(selectedOrgan: String, toggleView: View) {
        if (!isAcceptingInput) return
        isAcceptingInput = false
        var curStep = steps[currentStep]
        val isCorrect = when (curStep.correctOrgan) {
            "eyes" -> selectedOrgan == "eyes"
            "ears" -> selectedOrgan == "ears"
            else -> selectedOrgan == curStep.correctOrgan
        }
        val checkIv = toggleView as ToggleImageView
        checkIv.setToggleImage(isCorrect)
        AudioPlayerManger.playRaw(
            if (isCorrect) replyTrue.random() else {
                failNum++
                replyFalse.random()
            },
            object : IPlayCallBack {
                override fun onStart(index: Int) {
                }

                override fun onEnd(index: Int) {
                    if (isCorrect) {
                        currentStep++
                        startStep(currentStep)
                    } else {
                        startStep(currentStep)
                    }
                }
            })
    }

    override fun initView(savedInstanceState: Bundle?) {
        subject = arguments?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
        val views = listOf(
            mBinding.mouthIv,
            mBinding.noseIv,
            mBinding.ear1Iv,
            mBinding.ear2Iv,
            mBinding.eye1Iv,
            mBinding.eye2Iv
        )
        clickAbleViews.clear()
        clickAbleViews.addAll(views)
        currentStep = 0
        steps.clear()
        steps.add(Step(R.raw.l202q1, "mouth", mBinding.hamburgerIv))
        steps.add(Step(R.raw.l202q2, "eyes", mBinding.drawIv))
        steps.add(Step(R.raw.l202q3, "nose", mBinding.flowerIv))
        steps.add(Step(R.raw.l202q4, "ears", mBinding.headsetIv))
        clickAbleViews.forEach {
            it.setOnClickListener(handleClick)
        }
    }

    override fun onResume() {
        super.onResume()
        currentStep = 0
        failNum = 0
        AudioPlayerManger.playRaw(R.raw.l202dr, object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {
                startStep(currentStep)
            }
        })
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        currentStep = 0
        startStep(currentStep)
    }
}