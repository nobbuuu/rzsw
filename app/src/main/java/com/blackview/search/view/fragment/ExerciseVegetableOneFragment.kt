package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVegetableOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVegetableOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step4Iv, mBinding.step3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l366dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l366q1, R.raw.l366q2, R.raw.l366q3, R.raw.l366q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}