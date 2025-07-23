package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBodyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBodyTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBodyTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.step1Iv, mBinding.step2Iv, mBinding.step3Iv, mBinding.step4Iv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.my_body_hand, R.raw.my_body_arm, R.raw.my_body_wrist, R.raw.my_body_finger)
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