package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableFourBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.databinding.FragmentExerciseVegetableThreeBinding
import com.blackview.search.databinding.FragmentExerciseVegetableTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVegetableFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVegetableFourBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp2Iv, mBinding.setp4Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l370dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l370q1, R.raw.l370q2, R.raw.l370q3, R.raw.l370q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}