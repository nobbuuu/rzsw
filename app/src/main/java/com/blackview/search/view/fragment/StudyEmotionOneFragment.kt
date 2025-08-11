package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyEmotionOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyEmotionOneFragment : BaseStudyFragment<StudyExerciseViewModel, FragmentStudyEmotionOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.emotions_and_feelings_happy, R.raw.emotions_and_feelings_sad, R.raw.emotions_and_feelings_scared, R.raw.emotions_and_feelings_angry)
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