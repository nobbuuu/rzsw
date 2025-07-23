package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseActionTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseActionTwoFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseActionTwoBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.runBackIv, mBinding.walkBackIv, mBinding.standBackIv, mBinding.sitBackIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l220dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l220q1, R.raw.l220q2, R.raw.l220q3, R.raw.l220q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}