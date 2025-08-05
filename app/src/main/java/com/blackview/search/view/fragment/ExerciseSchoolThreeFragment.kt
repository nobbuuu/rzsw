package com.blackview.search.view.fragment

import com.blackview.search.R
import com.blackview.search.core.BaseExerciseFragment
import com.blackview.search.core.BaseLineFragment
import com.blackview.search.databinding.FragmentExerciseSchool1Binding
import com.blackview.search.databinding.FragmentExerciseSchool2Binding
import com.blackview.search.databinding.FragmentExerciseSchool3Binding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.LineView
import com.blackview.search.widget.ToggleImageView

class ExerciseSchoolThreeFragment :
    BaseLineFragment<StudyExerciseViewModel, FragmentExerciseSchool3Binding>() {

    override fun getToggleViews(): List<ToggleImageView> {
        return listOf(
            mBinding.setp2Iv,
            mBinding.setp1Iv,
            mBinding.setp4Iv,
            mBinding.setp3Iv,
            mBinding.setp5Iv,
            mBinding.setp6Iv,
            mBinding.setp7Iv,
            mBinding.setp8Iv
        )
    }

    override fun getLineView(): LineView {
        return mBinding.lineView
    }

    override fun getForewordRaw(): Int {
        return R.raw.l340dr
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }

    override fun getCorrectPairs(): List<Pair<Int, Int>> {
        return listOf(
            R.id.step1Iv to R.id.step7Iv,
            R.id.step3Iv to R.id.step8Iv,
            R.id.step6Iv to R.id.step4Iv,
            R.id.step5Iv to R.id.step2Iv
        )
    }
}