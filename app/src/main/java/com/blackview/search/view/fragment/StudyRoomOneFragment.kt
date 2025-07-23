package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyRoomOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyRoomOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyRoomOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_living_room_floor_lamp, R.raw.in_the_living_room_calendar, R.raw.in_the_living_room_remote_control, R.raw.in_the_living_room_switch)
    }

    override fun getForewordRaw(): Int = R.raw.l235dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}