package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketFiveBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySuperMarketFiveFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySupermarketFiveBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_supermarket_sugar, R.raw.in_the_supermarket_salt, R.raw.in_the_supermarket_oil, R.raw.in_the_supermarket_vinegor)
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