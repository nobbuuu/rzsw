package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBedroomFiveBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBedRoomFiveFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBedroomFiveBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_bedroom_window, R.raw.in_the_bedroom_curtain, R.raw.in_the_bedroom_door, R.raw.in_the_bedroom_handle)
    }

    override fun getForewordRaw(): Int = R.raw.l243dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}