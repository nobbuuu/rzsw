package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBedroomOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBedRoomOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBedroomOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l244dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l244q4, R.raw.l244q1, R.raw.l244q3, R.raw.l244q2)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}