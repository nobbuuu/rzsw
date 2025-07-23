package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyClothFiveBinding
import com.blackview.search.databinding.FragmentStudyKitchenOneBinding
import com.blackview.search.databinding.FragmentStudyKitchenTwoBinding
import com.blackview.search.databinding.FragmentStudyStudyOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyKitchenTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyKitchenTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.in_the_kitchen_spatula, R.raw.in_the_kitchen_range_hood, R.raw.in_the_kitchen_pan, R.raw.in_the_kitchen_gas_stove)
    }

    override fun getForewordRaw(): Int = R.raw.l271dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}