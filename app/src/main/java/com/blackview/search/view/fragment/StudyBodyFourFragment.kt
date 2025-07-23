package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBodyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBodyFourFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBodyFourBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.chestIv, mBinding.tummyIv, mBinding.backIv, mBinding.neckIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l207tp1, R.raw.l207tp2, R.raw.l207tp3, R.raw.l207tp4)
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