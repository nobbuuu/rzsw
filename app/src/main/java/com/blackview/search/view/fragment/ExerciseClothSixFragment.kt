package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseClothFourBinding
import com.blackview.search.databinding.FragmentExerciseClothSixBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseClothSixFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseClothSixBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l264dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l264q1, R.raw.l264q3, R.raw.l264q2, R.raw.l264q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}