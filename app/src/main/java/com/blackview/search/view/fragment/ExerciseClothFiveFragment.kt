package com.blackview.search.view.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.viewbinding.ViewBinding
import com.blackview.base.common.BaseViewModel
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.Step
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseClothFiveBinding
import com.blackview.search.databinding.FragmentExerciseClothFourBinding
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView
import kotlin.collections.forEach
 class ExerciseClothFiveFragment : BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseClothFiveBinding>() {
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
                        viewModel.update(stars, subject?.id.toString())
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
            if (isCorrect){
                when(selectedOrgan){
                    "step1" -> {
                        mBinding.monkey.setImageResource(R.mipmap.img_monkey_2)
                    }
                    "step2" -> {
                        mBinding.sheep.setImageResource(R.mipmap.img_sheep_2)
                    }
                    "step3" -> {
                        mBinding.elephant.setImageResource(R.mipmap.img_cat_2)
                    }
                    "step4" -> {
                        mBinding.rat.setImageResource(R.mipmap.img_rat_2)
                    }
                }
                replyTrue.random()
            }  else {
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

    override fun onResume() {
        super.onResume()
        clickAbleViews.clear()
        steps.clear()
        currentStep = 0
        failNum = 0
        mBinding.monkey.setImageResource(R.mipmap.img_monkey_1)
        mBinding.sheep.setImageResource(R.mipmap.img_sheep_1)
        mBinding.elephant.setImageResource(R.mipmap.img_cat_1)
        mBinding.rat.setImageResource(R.mipmap.img_rat_1)

        clickAbleViews.addAll(mutableListOf(mBinding.step1Iv,mBinding.step2Iv,mBinding.step3Iv,mBinding.step4Iv))
        intArrayOf(R.raw.l262q1,R.raw.l262q2,R.raw.l262q3,R.raw.l262q1).forEach {
            steps.add(Step(it, "step${steps.size + 1}", null))
        }
        clickAbleViews.forEach {
            it.setOnClickListener(handleClick)
            it.isShowToggleIv(false)
        }
        AudioPlayerManger.playRaw(R.raw.l262dr, object : IPlayCallBack {
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

}