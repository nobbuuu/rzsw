package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseClothThreeBinding
import com.blackview.search.databinding.FragmentExerciseStudyOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseStudyOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseStudyOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l266dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l266q1, R.raw.l266q2, R.raw.l258q4, R.raw.l258q3)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}