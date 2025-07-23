package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBedroomFiveBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBedRoomFiveFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBedroomFiveBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step5Iv, mBinding.step4Iv, mBinding.step3Iv, mBinding.step1Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l252dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l252q1, R.raw.l252q1, R.raw.l252q3, R.raw.l252q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}