package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseVehicleFiveBinding
import com.blackview.search.databinding.FragmentExerciseVehicleFourBinding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.databinding.FragmentExerciseVehicleTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVehicleFiveFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVehicleFiveBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp4Iv, mBinding.setp2Iv, mBinding.setp3Iv, mBinding.setp1Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l322dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l322q1, R.raw.l322q2, R.raw.l322q3, R.raw.l322q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}