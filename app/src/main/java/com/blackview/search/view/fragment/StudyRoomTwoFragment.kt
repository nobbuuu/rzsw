package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyRoomTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyRoomTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyRoomTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.in_the_living_room_plant,
            R.raw.in_the_living_room_birdcage,
            R.raw.in_the_living_room_vase,
            R.raw.in_the_living_room_fish_tank
        )
    }

    override fun getForewordRaw(): Int = R.raw.l237dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}