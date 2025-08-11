package com.blackview.search.view.fragment

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.Step
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.FragmentExerciseEmotionFourBinding
import com.blackview.search.dialog.CompleteDialog
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseEmotionFourFragment : BaseVoiceAgainFragment<StudyExerciseViewModel, FragmentExerciseEmotionFourBinding>() {
    private var currentStep = 0
    private var isAcceptingInput = false
    private val clickAbleViews: MutableList<ToggleImageView> = mutableListOf()
    private val checkMap = hashMapOf<String, HashMap<View, Boolean>>()
    val viewAnimMap = HashMap<View, ObjectAnimator>()
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
        clickAbleViews.forEach {
            viewAnimMap[it.getSrcIv()]?.cancel()
        }
        when (v.id) {
            R.id.step2Iv, R.id.step4Iv -> {
                checkAnswer("step1", v)
            }

            R.id.step1Iv, R.id.step3Iv -> {
                checkAnswer("step2", v)
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
                /*clickAbleViews.forEach {
                    viewAnimMap.get(it.getSrcIv())?.start()
                }*/
            }
        })
    }

    private fun checkAnswer(selectedOrgan: String, clickView: View) {
        if (!isAcceptingInput) return
        isAcceptingInput = false
        var curStep = steps[currentStep]
        val isCorrect = when (curStep.correctOrgan) {
            "step1" -> {
                val isRight = selectedOrgan == "step1"
                val socksMap = checkMap.get(selectedOrgan)
                socksMap?.put(clickView, isRight)
                checkMap.put(selectedOrgan, socksMap!!)
                isRight
            }

            "step2" -> {
                val isRight = selectedOrgan == "step2"
                val shoeMap = checkMap.get(selectedOrgan)
                shoeMap?.put(clickView, isRight)
                checkMap.put(selectedOrgan, shoeMap!!)
                isRight
            }

            else -> selectedOrgan == curStep.correctOrgan
        }
        val checkIv = clickView as ToggleImageView
        checkIv.setToggleImage(isCorrect == true)
        if (!isCorrect) {
            AudioPlayerManger.playRaw(replyFalse.random())
            isAcceptingInput = true
            failNum++
        } else {
            val isAllCorrect = checkMap.get(selectedOrgan)?.all { it.value == true }
            if (!isAllCorrect!!) {
//                AudioPlayerManger.playRaw(R.raw.and)
                isAcceptingInput = true
            } else {
                AudioPlayerManger.playRaw(
                    replyTrue.random(),
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
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        subject = arguments?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
    }

    override fun onResume() {
        super.onResume()
        viewAnimMap.clear()
        steps.clear()
        clickAbleViews.clear()
        checkMap.clear()
        currentStep = 0
        failNum = 0
        val views = listOf(
            mBinding.step1Iv,
            mBinding.step2Iv,
            mBinding.step3Iv,
            mBinding.step4Iv,
        )
        clickAbleViews.addAll(views)
        steps.add(Step(R.raw.l216q1, "step1", null))
        steps.add(Step(R.raw.l216q3, "step2", null))
        clickAbleViews.forEach {
            it.setOnClickListener(handleClick)
            it.isShowToggleIv(false)
            initViewAnim(it.getSrcIv())
        }
        val socksMap = hashMapOf<View, Boolean>()
        val shoeMap = hashMapOf<View, Boolean>()
        socksMap.put(mBinding.step2Iv, false)
        socksMap.put(mBinding.step4Iv, false)
        shoeMap.put(mBinding.step1Iv, false)
        shoeMap.put(mBinding.step3Iv, false)
        checkMap.put("step1", socksMap)
        checkMap.put("step2", shoeMap)

        AudioPlayerManger.playRaw(R.raw.l216dr, object : IPlayCallBack {
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

    fun initViewAnim(view: View) {
        // 创建缩放动画
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 0.8f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 0.8f)
        var animator = ObjectAnimator.ofPropertyValuesHolder(
            view,
            scaleX,
            scaleY
        ).apply {
            this.duration = 500
            startDelay = 0
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            interpolator = LinearInterpolator()
        }
        viewAnimMap.put(view, animator)
    }
}