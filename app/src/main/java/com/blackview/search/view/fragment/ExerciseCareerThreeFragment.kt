package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseCareer1Binding
import com.blackview.search.databinding.FragmentExerciseCareer2Binding
import com.blackview.search.databinding.FragmentExerciseCareer3Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseCareerThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseCareer3Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp2Iv, mBinding.setp7Iv, mBinding.setp6Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l348dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l348q1, R.raw.l348q2, R.raw.l348q3, R.raw.l348q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}