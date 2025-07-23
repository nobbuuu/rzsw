package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyToyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyToyFourFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyToyFourBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.in_the_toy_room_rubiks_cube,
            R.raw.in_the_toy_room_windmill,
            R.raw.in_the_toy_room_marble,
            R.raw.in_the_toy_room_top
        )
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