package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseActionOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseActionOneFragment : BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseActionOneBinding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.eatBackIv, mBinding.singBackIv, mBinding.drinkBackIv, mBinding.speakBackIv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l218dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l218q2, R.raw.l218q3, R.raw.l218q1, R.raw.l218q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star,subject?.id.toString())
    }
}