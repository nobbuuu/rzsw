package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothFiveBinding
import com.blackview.search.databinding.FragmentStudyClothFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyClothFiveFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyClothFiveBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.clothing_leotard, R.raw.clothing_skirt, R.raw.clothing_nightgown, R.raw.clothing_evening_dress)
    }

    override fun getForewordRaw(): Int = R.raw.l253dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}