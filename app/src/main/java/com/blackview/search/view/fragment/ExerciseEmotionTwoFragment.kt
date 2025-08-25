package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseEmotionTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseEmotionTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseEmotionTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.surprisedBigIv, mBinding.shyIv, mBinding.nervousBigIv, mBinding.worriedIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l212dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l212q1, R.raw.l212q2, R.raw.l212q3, R.raw.l212q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}