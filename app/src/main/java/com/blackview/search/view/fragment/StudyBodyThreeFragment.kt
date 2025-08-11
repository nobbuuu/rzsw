package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBodyThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBodyThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBodyThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.footIv, mBinding.toeIv, mBinding.kneeIv, mBinding.legIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.my_body_foot, R.raw.my_body_toe, R.raw.my_body_knee, R.raw.my_body_leg)
    }

    override fun getForewordRaw(): Int = R.raw.study_body_1_title

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}