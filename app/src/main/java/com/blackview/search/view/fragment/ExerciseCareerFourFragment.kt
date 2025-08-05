package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseCareer1Binding
import com.blackview.search.databinding.FragmentExerciseCareer2Binding
import com.blackview.search.databinding.FragmentExerciseCareer3Binding
import com.blackview.search.databinding.FragmentExerciseCareer4Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseCareerFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseCareer4Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp3Iv, mBinding.setp4Iv, mBinding.setp1Iv, mBinding.setp2Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l350dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l350q1, R.raw.l350q2, R.raw.l350q3, R.raw.l350q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}