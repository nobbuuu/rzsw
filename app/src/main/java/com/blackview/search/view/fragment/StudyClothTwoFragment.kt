package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyClothTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyClothTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(
            R.raw.clothing_suit,
            R.raw.clothing_shirt,
            R.raw.clothing_polo_shirt,
            R.raw.clothing_hoodie
        )
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