package com.blackview.search.view.fragment

import android.widget.ImageView
import com.blackview.search.R
import com.blackview.search.core.BaseLineFragment
import com.blackview.search.databinding.FragmentExerciseConstructionSiteTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blackview.search.widget.LineView

class ExerciseConstructionTwoFragment :
    BaseLineFragment<StudyExerciseViewModel, FragmentExerciseConstructionSiteTwoBinding>() {

    override fun getClickViews(): List<ImageView> {
        return listOf(mBinding.setp1Iv, mBinding.setp4Iv, mBinding.setp2Iv, mBinding.setp3Iv)
    }

    override fun getLineView(): LineView {
        return mBinding.lineView
    }

    override fun getForewordRaw(): Int {
        return R.raw.l326dr
    }

    override fun updateStar(star: Int) {
        viewModel.update(star, subject?.id.toString())
    }

    override fun getCorrectPairs(): List<Pair<Int, Int>> {
        return listOf(
            R.id.step1Iv to R.id.step6Iv,
            R.id.step2Iv to R.id.step8Iv,
            R.id.step3Iv to R.id.step7Iv,
            R.id.step4Iv to R.id.step5Iv
        )
    }
}