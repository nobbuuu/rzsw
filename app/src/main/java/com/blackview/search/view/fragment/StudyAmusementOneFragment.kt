package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyAmusementParkBinding
import com.blackview.search.databinding.FragmentStudyConcertBinding
import com.blackview.search.databinding.FragmentStudyFruitBinding
import com.blackview.search.databinding.FragmentStudyNutBinding
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.databinding.FragmentStudyVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyAmusementOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyAmusementParkBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.at_the_amusement_french_fry, R.raw.at_the_amusement_donut, R.raw.at_the_amusement_cotton_candy, R.raw.at_the_amusement_ice_cream)
    }

    override fun getForewordRaw(): Int = R.raw.l389dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}