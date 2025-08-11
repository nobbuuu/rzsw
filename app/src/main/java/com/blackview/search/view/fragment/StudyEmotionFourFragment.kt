package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyEmotionFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyEmotionFourFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyEmotionFourBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.emotions_and_feelings_cold,
            R.raw.emotions_and_feelings_hot,
            R.raw.emotions_and_feelings_full,
            R.raw.emotions_and_feelings_hungry
        )
    }

    override fun getForewordRaw(): Int = R.raw.l209dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}