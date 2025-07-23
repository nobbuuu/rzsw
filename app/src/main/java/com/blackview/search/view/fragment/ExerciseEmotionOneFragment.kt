package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseEmotionOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseEmotionOneFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseEmotionOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.angryIv, mBinding.afraidIv, mBinding.happyIv, mBinding.sadIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l210dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l210q1, R.raw.l210q2, R.raw.l210q3, R.raw.l210q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}