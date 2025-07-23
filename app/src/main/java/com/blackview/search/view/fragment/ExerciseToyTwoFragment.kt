package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseToyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseToyTwoFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseToyTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l230dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l230q1, R.raw.l230q2, R.raw.l230q3, R.raw.l230q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id)
    }
}