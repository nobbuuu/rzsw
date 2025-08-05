package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseVehicleFourBinding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.databinding.FragmentExerciseVehicleTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVehicleFourFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVehicleFourBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp6Iv, mBinding.setp4Iv, mBinding.setp3Iv, mBinding.setp1Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l320dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l320q1, R.raw.l320q2, R.raw.l320q3, R.raw.l320q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}