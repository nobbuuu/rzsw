package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSupermarketSixFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSupermarketSixBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp3Iv, mBinding.setp4Iv, mBinding.setp8Iv, mBinding.setp7Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l364dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l364q1, R.raw.l364q2, R.raw.l364q3, R.raw.l364q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}