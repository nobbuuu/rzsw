package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyClothThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyClothThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.clothing_underwear, R.raw.clothing_sock, R.raw.clothing_pajamas, R.raw.clothing_tank_top)
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