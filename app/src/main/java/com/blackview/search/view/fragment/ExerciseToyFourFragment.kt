package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseToyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseToyFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseToyFourBinding>() {
    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l234dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l234q1, R.raw.l234q2, R.raw.l234q3, R.raw.l234q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id)
    }

}