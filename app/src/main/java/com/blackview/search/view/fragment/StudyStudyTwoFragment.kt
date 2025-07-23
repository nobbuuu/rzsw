package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothFiveBinding
import com.blackview.search.databinding.FragmentStudyStudyOneBinding
import com.blackview.search.databinding.FragmentStudyStudyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyStudyTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyStudyTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_study_stapler, R.raw.in_the_study_paper_clip, R.raw.in_the_study_thumbtack, R.raw.in_the_study_printer)
    }

    override fun getForewordRaw(): Int = R.raw.l265dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}