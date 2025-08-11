package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySignBinding
import com.blackview.search.databinding.FragmentStudySignTwoBinding
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySignTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySignTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.signs_no_entry, R.raw.signs_caution_wet_floor, R.raw.signs_watch_your_head, R.raw.signs_watch_your_step)
    }

    override fun getForewordRaw(): Int = R.raw.l393dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}