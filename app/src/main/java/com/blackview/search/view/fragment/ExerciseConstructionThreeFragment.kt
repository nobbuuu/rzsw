package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseConstructionSiteThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseConstructionThreeFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseConstructionSiteThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp2Iv, mBinding.setp4Iv, mBinding.setp3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l328dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l328q1, R.raw.l328q2, R.raw.l328q3, R.raw.l328q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}