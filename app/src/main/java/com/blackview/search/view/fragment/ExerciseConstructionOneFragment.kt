package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseConstructionSiteOneBinding
import com.blackview.search.databinding.FragmentExerciseVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseConstructionOneFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseConstructionSiteOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp4Iv, mBinding.setp2Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l324dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l324q2, R.raw.l324q2, R.raw.l324q3, R.raw.l324q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}