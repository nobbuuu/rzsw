package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseHospital1Binding
import com.blackview.search.databinding.FragmentExerciseHospital2Binding
import com.blackview.search.databinding.FragmentExerciseHospital3Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseHospitalThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseHospital3Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp2Iv, mBinding.setp1Iv, mBinding.setp3Iv, mBinding.setp4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l334dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l334q1, R.raw.l334q2, R.raw.l334q3, R.raw.l334q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}