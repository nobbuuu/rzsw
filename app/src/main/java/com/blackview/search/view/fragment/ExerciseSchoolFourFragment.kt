package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSchool1Binding
import com.blackview.search.databinding.FragmentExerciseSchool2Binding
import com.blackview.search.databinding.FragmentExerciseSchool4Binding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSchoolFourFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSchool4Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp7Iv, mBinding.setp2Iv, mBinding.setp6Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l342dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l342q1, R.raw.l342q2, R.raw.l342q3, R.raw.l342q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}