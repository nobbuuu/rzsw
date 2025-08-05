package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothOneBinding
import com.blackview.search.databinding.FragmentStudyConstructionSiteOneBinding
import com.blackview.search.databinding.FragmentStudyConstructionSiteTwoBinding
import com.blackview.search.databinding.FragmentStudyStreetOneBinding
import com.blackview.search.databinding.FragmentStudyVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyConstructionTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyConstructionSiteTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.threeIv, mBinding.twoIv, mBinding.oneIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.at_the_construction_site_tanker, R.raw.at_the_construction_site_forklift, R.raw.at_the_construction_site_dump_truck, R.raw.at_the_construction_site_wheelbarrow)
    }

    override fun getForewordRaw(): Int = R.raw.l323dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}