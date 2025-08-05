package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseHospital1Binding
import com.blackview.search.databinding.FragmentExerciseHospital2Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseHospitalTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseHospital2Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp3Iv, mBinding.setp2Iv, mBinding.setp1Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l332dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l332q1, R.raw.l332q2, R.raw.l332q3)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}