package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothOneBinding
import com.blackview.search.databinding.FragmentStudyStreetFourBinding
import com.blackview.search.databinding.FragmentStudyStreetOneBinding
import com.blackview.search.databinding.FragmentStudyStreetThreeBinding
import com.blackview.search.databinding.FragmentStudyStreetTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyStreetFourFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyStreetFourBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.on_the_street_road_sign, R.raw.on_the_street_traffic_light, R.raw.on_the_street_tree, R.raw.on_the_street_streetlight)
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