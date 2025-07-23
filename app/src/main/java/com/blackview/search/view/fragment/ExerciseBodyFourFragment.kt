package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBodyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBodyFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBodyFourBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.exTummyIv, mBinding.exChestIv, mBinding.exBackIv, mBinding.exNeckIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l208dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l208q1, R.raw.l208q2, R.raw.l208q3, R.raw.l208q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}