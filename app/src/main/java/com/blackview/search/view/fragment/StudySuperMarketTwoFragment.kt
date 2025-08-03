package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySuperMarketTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySupermarketTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_supermarket_receipt, R.raw.in_the_supermarket_bank_card, R.raw.in_the_supermarket_money, R.raw.in_the_supermarket_coin)
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