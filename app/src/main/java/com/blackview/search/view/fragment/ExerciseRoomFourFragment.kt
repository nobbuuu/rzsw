package com.blackview.search.view.fragment

import android.os.Bundle
import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.databinding.FragmentExerciseRoomFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.ToggleImageView

class ExerciseRoomFourFragment :
    BaseExerciseFragment<StudyExerciseViewModel, FragmentExerciseRoomFourBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mBinding.step2Iv
    }
    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getForewordRaw(): Int {
        return R.raw.l242dr
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l242q1, R.raw.l242q2, R.raw.l242q3, R.raw.l242q4)
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }
}