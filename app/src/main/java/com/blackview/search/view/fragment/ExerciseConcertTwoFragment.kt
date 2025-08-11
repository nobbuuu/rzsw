package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseConcertBinding
import com.blackview.search.databinding.FragmentExerciseConcertTwoBinding
import com.blackview.search.databinding.FragmentExerciseFruitBinding
import com.blackview.search.databinding.FragmentExerciseNutBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseConcertTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseConcertTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.angryIv, mBinding.happyIv, mBinding.afraidIv, mBinding.sadIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l384dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l384q1, R.raw.l384q2, R.raw.l384q3, R.raw.l384q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}