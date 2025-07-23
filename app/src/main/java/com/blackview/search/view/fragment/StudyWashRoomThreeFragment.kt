package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBathroomOneBinding
import com.blackview.search.databinding.FragmentStudyWashhouseOneBinding
import com.blackview.search.databinding.FragmentStudyWashhouseThreeBinding
import com.blackview.search.databinding.FragmentStudyWashhouseTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyWashRoomThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyWashhouseThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.in_the_laundry_room_brush,
            R.raw.in_the_laundry_room_mop,
            R.raw.in_the_laundry_room_broom,
            R.raw.in_the_laundry_room_trash_can
        )
    }

    override fun getForewordRaw(): Int = R.raw.l285dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}