package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBathroomOneBinding
import com.blackview.search.databinding.FragmentStudyClothThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBathroomOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBathroomOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_bathroom_shower, R.raw.in_the_bathroom_faucet, R.raw.in_the_bathroom_bathtub, R.raw.in_the_bathroom_toilet)
    }

    override fun getForewordRaw(): Int = R.raw.l279dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}