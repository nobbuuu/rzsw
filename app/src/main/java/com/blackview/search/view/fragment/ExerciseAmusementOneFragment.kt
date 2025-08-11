package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseAmusementParkBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseAmusementOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseAmusementParkBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.sad6Iv, mBinding.step3Iv, mBinding.step4Iv, mBinding.step2Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l390dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l390q1, R.raw.l390q2, R.raw.l390q3, R.raw.l390q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}