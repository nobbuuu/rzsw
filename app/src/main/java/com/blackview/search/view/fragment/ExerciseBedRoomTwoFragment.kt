package com.blackview.search.view.fragment

import androidx.core.view.isInvisible
import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBedroomTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBedRoomTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBedroomTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step4Iv, mBinding.step3Iv, mBinding.step1Iv, mBinding.step2Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l246dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l246q1, R.raw.l246q2, R.raw.l246q3, R.raw.l246q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }

    override fun onResume() {
        super.onResume()
        mBinding.step1Iv.isInvisible = false
        mBinding.step2Iv.isInvisible = false
        mBinding.step3Iv.isInvisible = false
        mBinding.step4Iv.isInvisible = false
        mBinding.bedIv.setImageResource(R.mipmap.img_bed)
    }
    override fun onCorrect(isCorrect: Boolean, step: String) {
        super.onCorrect(isCorrect, step)
        if (isCorrect){
            when (step) {
                "step1" -> {
                    mBinding.step4Iv.isInvisible = true
                    mBinding.bedIv.setImageResource(R.mipmap.img_sheet_2)
                }

                "step2" -> {
                    mBinding.step3Iv.isInvisible = true
                    mBinding.bedIv.setImageResource(R.mipmap.img_pillow_2)
                }

                "step3" -> {
                    mBinding.step1Iv.isInvisible = true
                    mBinding.bedIv.setImageResource(R.mipmap.img_quilt_2)
                }

                "step4" -> {
                    mBinding.step2Iv.isInvisible = true
                    mBinding.bedIv.setImageResource(R.mipmap.img_blanket_2)
                }
            }
        }
    }
}