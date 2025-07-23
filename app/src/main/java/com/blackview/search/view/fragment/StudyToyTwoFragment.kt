package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyToyTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyToyTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyToyTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }


    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_toy_room_dart, R.raw.in_the_toy_room_target, R.raw.in_the_toy_room_board_game, R.raw.in_the_toy_room_chess_piece)
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