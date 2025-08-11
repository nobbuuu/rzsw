package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSupermarketFiveFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSupermarketFiveBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp4Iv, mBinding.setp8Iv, mBinding.setp7Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l362dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l362q1, R.raw.l362q2, R.raw.l362q3, R.raw.l362q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}