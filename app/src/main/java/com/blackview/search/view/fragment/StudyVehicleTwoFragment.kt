package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothOneBinding
import com.blackview.search.databinding.FragmentStudyStreetOneBinding
import com.blackview.search.databinding.FragmentStudyVehicleOneBinding
import com.blackview.search.databinding.FragmentStudyVehicleTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyVehicleTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyVehicleTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.transportation_subway, R.raw.transportation_cable_car, R.raw.transportation_train, R.raw.transportation_tram)
    }

    override fun getForewordRaw(): Int = R.raw.l313dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}