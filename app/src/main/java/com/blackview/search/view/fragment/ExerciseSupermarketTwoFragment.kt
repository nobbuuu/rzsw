package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSupermarketTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSupermarketTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step5Iv, mBinding.step6Iv, mBinding.step2Iv, mBinding.step3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l356dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l356q1, R.raw.l356q2, R.raw.l356q3, R.raw.l356q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}