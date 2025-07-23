package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothFiveBinding
import com.blackview.search.databinding.FragmentStudyClothFourBinding
import com.blackview.search.databinding.FragmentStudyClothSixBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyClothSixFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyClothSixBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.clothing_jeans, R.raw.clothing_pants, R.raw.clothing_tracksuit_bottoms, R.raw.clothing_overalls)
    }

    override fun getForewordRaw(): Int = R.raw.l261dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}