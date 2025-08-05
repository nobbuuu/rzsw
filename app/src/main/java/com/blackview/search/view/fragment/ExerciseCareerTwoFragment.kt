package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseCareer1Binding
import com.blackview.search.databinding.FragmentExerciseCareer2Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseCareerTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseCareer2Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp4Iv, mBinding.setp2Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l346dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l346q1, R.raw.l346q2, R.raw.l346q3, R.raw.l346q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}