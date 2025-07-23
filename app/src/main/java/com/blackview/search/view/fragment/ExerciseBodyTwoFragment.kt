package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBodyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBodyTwoFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBodyTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l204dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l204q4, R.raw.l204q3, R.raw.l204q2, R.raw.l204q1)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}