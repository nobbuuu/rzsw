package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseCareer1Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseCareerOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseCareer1Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp3Iv, mBinding.setp7Iv, mBinding.setp2Iv, mBinding.setp4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l344dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l344q1, R.raw.l344q2, R.raw.l344q3, R.raw.l344q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}