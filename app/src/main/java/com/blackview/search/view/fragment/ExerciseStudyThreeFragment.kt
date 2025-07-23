package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseClothThreeBinding
import com.blackview.search.databinding.FragmentExerciseStudyOneBinding
import com.blackview.search.databinding.FragmentExerciseStudyThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseStudyThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseStudyThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l270dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l270q1, R.raw.l270q2, R.raw.l270q3, R.raw.l270q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}