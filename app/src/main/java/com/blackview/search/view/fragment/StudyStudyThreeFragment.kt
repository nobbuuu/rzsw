package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothFiveBinding
import com.blackview.search.databinding.FragmentStudyStudyOneBinding
import com.blackview.search.databinding.FragmentStudyStudyThreeBinding
import com.blackview.search.databinding.FragmentStudyStudyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyStudyThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyStudyThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_study_book, R.raw.in_the_study_dictionary, R.raw.in_the_study_bookmark, R.raw.in_the_study_bookself)
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