package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseAmusementParkBinding
import com.blackview.search.databinding.FragmentExerciseSign2Binding
import com.blackview.search.databinding.FragmentExerciseSignBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFiveBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketFourBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketSixBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketThreeBinding
import com.blackview.search.databinding.FragmentExerciseSupermarketTwoBinding
import com.blackview.search.databinding.FragmentExerciseVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSignTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSign2Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.oneIv, mBinding.threeIv, mBinding.twoIv, mBinding.fourIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l396dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l396q1, R.raw.l396q2, R.raw.l396q3, R.raw.l396q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}