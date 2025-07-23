package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseBedroomFourBinding
import com.blackview.search.databinding.FragmentExerciseBirthdayOneBinding
import com.blackview.search.databinding.FragmentExerciseBirthdayThreeBinding
import com.blackview.search.databinding.FragmentExerciseWashhouseOneBinding
import com.blackview.search.databinding.FragmentExerciseWashhouseThreeBinding
import com.blackview.search.databinding.FragmentExerciseWashhouseTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseBirthdayThreeFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseBirthdayThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l296dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l296q4, R.raw.l296q3, R.raw.l296q1, R.raw.l292q2)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}