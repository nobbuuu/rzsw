package com.blackview.search.view.fragment

import android.os.Bundle
import android.view.View
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.kt.ktClick
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.Step
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseToyThreeBinding
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseToyThreeFragment :
    BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseToyThreeBinding>() {
    private var currentStep = 0
    private var isAcceptingInput = false
    private val clickAbleViews: MutableList<ToggleImageView> = mutableListOf()
    private var failNum = 0
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
            R.id.step1Iv -> {
                checkAnswer("step1", v)
            }

            R.id.step2Iv -> {
                checkAnswer("step2", v)
            }

            R.id.step3Iv -> {
                checkAnswer("step3", v)
            }

            R.id.step4Iv -> {
                checkAnswer("step4", v)
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
    }

    override fun onResume() {
        super.onResume()
        clickAbleViews.clear()
        steps.clear()
        currentStep = 0
        failNum = 0
        val views = listOf(
            mBinding.step1Iv,
            mBinding.step2Iv,
            mBinding.step3Iv,
            mBinding.step4Iv
        )
        clickAbleViews.addAll(views)
        steps.add(Step(R.raw.l232q5, "step1", null))
        steps.add(Step(R.raw.l232q4, "step2", null))
        steps.add(Step(R.raw.l232q2, "step3", null))
        steps.add(Step(R.raw.l232q3, "step4", null))
        clickAbleViews.forEach {
            it.setOnClickListener(handleClick)
            it.isShowToggleIv(false)
        }
        AudioPlayerManger.playRaw(R.raw.l232dr, object : IPlayCallBack {
            override fun onStart(index: Int) {
            }

            override fun onEnd(index: Int) {
                AudioPlayerManger.playRaw(R.raw.l232q1, object : IPlayCallBack {
                    override fun onStart(index: Int) {
                    }

                    override fun onEnd(index: Int) {
                        mBinding.machineIv.ktClick {
                            startStep(currentStep)
                        }
                    }
                })
            }
        })
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        startStep(currentStep)
    }
}