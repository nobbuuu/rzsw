package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothOneBinding
import com.blackview.search.databinding.FragmentStudyConstructionSiteOneBinding
import com.blackview.search.databinding.FragmentStudyHospitalOneBinding
import com.blackview.search.databinding.FragmentStudySchoolOneBinding
import com.blackview.search.databinding.FragmentStudySchoolTwoBinding
import com.blackview.search.databinding.FragmentStudyStreetOneBinding
import com.blackview.search.databinding.FragmentStudyVehicleOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudySchoolTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudySchoolTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.threeIv, mBinding.twoIv, mBinding.oneIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.at_school_blackboard, R.raw.at_school_chalk, R.raw.at_school_triangle_ruler, R.raw.at_school_globe)
    }

    override fun getForewordRaw(): Int = R.raw.l335dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}