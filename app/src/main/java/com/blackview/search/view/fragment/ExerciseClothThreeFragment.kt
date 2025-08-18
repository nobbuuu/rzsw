package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseClothThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseClothThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseClothThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step4Iv, mBinding.step2Iv, mBinding.step1Iv, mBinding.step3Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l258dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l258q1, R.raw.l258q2, R.raw.l258q3, R.raw.l258q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}