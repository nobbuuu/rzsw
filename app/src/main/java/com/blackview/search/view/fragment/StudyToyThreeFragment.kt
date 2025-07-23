package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyToyThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyToyThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyToyThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.in_the_toy_room_gamepad,
            R.raw.in_the_toy_room_game_console,
            R.raw.in_the_toy_room_game_card,
            R.raw.in_the_toy_room_yoyo
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