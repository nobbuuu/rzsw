package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSchool1Binding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSchoolOneFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSchool1Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp2Iv, mBinding.setp3Iv, mBinding.setp4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l336dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l336q1, R.raw.l336q2, R.raw.l336q3, R.raw.l336q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}