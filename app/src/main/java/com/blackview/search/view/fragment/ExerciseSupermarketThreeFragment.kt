package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSupermarketThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSupermarketThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step6Iv, mBinding.step8Iv, mBinding.step7Iv, mBinding.step5Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l358dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l358q1, R.raw.l358q2, R.raw.l358q3, R.raw.l358q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}