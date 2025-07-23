package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBathroomTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBathroomTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBathroomTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_bathroom_sponge, R.raw.in_the_bathroom_shower_gel, R.raw.in_the_bathroom_soap, R.raw.in_the_bathroom_toilet)
    }

    override fun getForewordRaw(): Int = R.raw.l279dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}