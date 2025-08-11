package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseFruitBinding
import com.blackview.search.databinding.FragmentExerciseFruitTwoBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseFruitTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseFruitTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.imageView6, mBinding.imageView, mBinding.imageView5, mBinding.imageView7)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l376dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l376q1, R.raw.l376q2, R.raw.l376q3, R.raw.l376q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}