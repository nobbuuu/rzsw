package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseVehicleOneFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseVehicleOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp2Iv, mBinding.setp3Iv, mBinding.setp4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l314dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l218q2, R.raw.l218q3, R.raw.l218q1, R.raw.l218q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}