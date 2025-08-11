package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketFiveBinding
import com.blackview.search.databinding.FragmentStudySupermarketSixBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySuperMarketSixFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySupermarketSixBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.threeIv, mBinding.twoIv, mBinding.oneIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_supermarket_bread, R.raw.in_the_supermarket_flour, R.raw.in_the_supermarket_corn, R.raw.in_the_supermarket_cereal)
    }

    override fun getForewordRaw(): Int = R.raw.l353dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}