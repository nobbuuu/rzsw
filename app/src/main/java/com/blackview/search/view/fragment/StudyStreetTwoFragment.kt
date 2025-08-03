package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothOneBinding
import com.blackview.search.databinding.FragmentStudyStreetOneBinding
import com.blackview.search.databinding.FragmentStudyStreetTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyStreetTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyStreetTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.on_the_street_pharmacy, R.raw.on_the_street_bakery, R.raw.on_the_street_bookstore, R.raw.on_the_street_hotel)
    }

    override fun getForewordRaw(): Int = R.raw.l301dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}