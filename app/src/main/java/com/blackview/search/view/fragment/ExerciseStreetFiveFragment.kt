package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseClothOneBinding
import com.blackview.search.databinding.FragmentExerciseStreetFiveBinding
import com.blackview.search.databinding.FragmentExerciseStreetFourBinding
import com.blackview.search.databinding.FragmentExerciseStreetOneBinding
import com.blackview.search.databinding.FragmentExerciseStreetTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseStreetFiveFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseStreetFiveBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l310dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l310q1, R.raw.l310q2, R.raw.l310q3, R.raw.l310q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}