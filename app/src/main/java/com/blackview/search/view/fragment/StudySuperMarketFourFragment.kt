package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketThreeBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySuperMarketFourFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySupermarketThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_supermarket_pudding, R.raw.in_the_supermarket_crisp, R.raw.in_the_supermarket_chocolate, R.raw.in_the_supermarket_yogurt)
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