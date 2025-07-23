package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBedroomFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBedRoomFourFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBedroomFourBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l250dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l248q3, R.raw.l248q2, R.raw.l248q1, R.raw.l248q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}