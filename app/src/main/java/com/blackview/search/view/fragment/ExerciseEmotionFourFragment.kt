package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseEmotionFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseEmotionFourFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseEmotionFourBinding>() {
    override fun getToggleViews(): List<ToggleImageView> {
        return mutableListOf(mBinding.step2Iv,mBinding.step1Iv)
    }

    override fun getForewordRaw(): Int = R.raw.l216dr

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l216q1, R.raw.l216q3)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }

}