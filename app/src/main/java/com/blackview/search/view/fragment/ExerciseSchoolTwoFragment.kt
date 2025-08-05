package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseSchool1Binding
import com.blackview.search.databinding.FragmentExerciseSchool2Binding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseSchoolTwoFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseSchool2Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp2Iv, mBinding.setp1Iv, mBinding.setp4Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l338dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l338q1, R.raw.l338q2, R.raw.l338q3, R.raw.l338q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}