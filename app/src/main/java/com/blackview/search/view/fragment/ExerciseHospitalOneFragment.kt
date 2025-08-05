package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseHospital1Binding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseHospitalOneFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseHospital1Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp4Iv, mBinding.setp3Iv, mBinding.setp2Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l330dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l330q1, R.raw.l330q2, R.raw.l330q3, R.raw.l330q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}