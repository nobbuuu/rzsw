package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketOneBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSupermarketOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSupermarketOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp3Iv, mBinding.setp7Iv, mBinding.setp4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l354dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l354q1, R.raw.l354q2, R.raw.l354q3, R.raw.l354q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}