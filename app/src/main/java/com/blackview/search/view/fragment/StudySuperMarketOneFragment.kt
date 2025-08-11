package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySuperMarketOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySupermarketOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.threeIv, mBinding.twoIv, mBinding.oneIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_supermarket_cashier, R.raw.in_the_supermarket_cash_register, R.raw.in_the_supermarket_shopping_basket, R.raw.in_the_supermarket_shopping_cart)
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