package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseEmotionThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseEmotionThreeFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseEmotionThreeBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.comfortableIv, mBinding.tiredIv, mBinding.painfulIv, mBinding.relaxedIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l214dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l214q1, R.raw.l214q2, R.raw.l214q3, R.raw.l214q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}