package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseCareer1Binding
import com.blackview.search.databinding.FragmentExerciseCareer2Binding
import com.blackview.search.databinding.FragmentExerciseCareer3Binding
import com.blackview.search.databinding.FragmentExerciseCareer4Binding
import com.blackview.search.databinding.FragmentExerciseCareer5Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseCareerFiveFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseCareer5Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp6Iv, mBinding.setp2Iv, mBinding.setp5Iv, mBinding.setp1Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l352dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l352q1, R.raw.l352q2, R.raw.l352q3, R.raw.l352q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}