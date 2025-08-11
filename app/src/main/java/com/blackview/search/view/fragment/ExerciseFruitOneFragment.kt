package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseFruitBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseFruitOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseFruitBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.twoIv, mBinding.threeIv, mBinding.fourIv, mBinding.oneIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l374dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l374q1, R.raw.l374q2, R.raw.l374q3, R.raw.l374q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}