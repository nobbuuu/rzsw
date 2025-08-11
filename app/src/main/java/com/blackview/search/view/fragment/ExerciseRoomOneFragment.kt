package com.blackview.search.view.fragment

import android.widget.ImageView
import com.blackview.search.R
import com.blackview.search.core.BaseLineFragment
import com.blackview.search.databinding.FragmentExerciseRoomOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.LineView

class ExerciseRoomOneFragment :
    BaseLineFragment<StudyExerciseViewModel, FragmentExerciseRoomOneBinding>() {
    override fun getClickViews(): List<ImageView> {
        return mutableListOf(
            mBinding.step1Iv,
            mBinding.step2Iv,
            mBinding.step3Iv,
            mBinding.step4Iv,
            mBinding.calendarIv,
            mBinding.controlIv,
            mBinding.switchIv,
            mBinding.lampIv
        )
    }

    override fun getLineView(): LineView {
        return mBinding.lineView
    }

    override fun getForewordRaw(): Int {
        return R.raw.l236dr
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id)
    }

    override fun getCorrectPairs(): List<Pair<Int, Int>> {
        return listOf(
            R.id.step1Iv to R.id.calendarIv,
            R.id.step2Iv to R.id.controlIv,
            R.id.step3Iv to R.id.switchIv,
            R.id.step4Iv to R.id.lampIv
        )
    }


}