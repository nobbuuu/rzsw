package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseActionFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseActionFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseActionFourBinding>() {
    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l224dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l224q2, R.raw.l224q1, R.raw.l224q3)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }

}