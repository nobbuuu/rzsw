package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyToyOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyToyOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyToyOneBinding>() {
    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_toy_room_doll, R.raw.in_the_toy_room_puppet, R.raw.in_the_toy_room_building_block, R.raw.in_the_toy_room_picture_book)
    }

    override fun getForewordRaw(): Int = R.raw.l227dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }

}