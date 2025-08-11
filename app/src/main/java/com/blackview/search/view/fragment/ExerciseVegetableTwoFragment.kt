package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.databinding.FragmentExerciseVegetableTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVegetableTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVegetableTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp6Iv, mBinding.setp5Iv, mBinding.setp7Iv, mBinding.setp8Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l368dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l368q1, R.raw.l368q2, R.raw.l368q3, R.raw.l368q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}