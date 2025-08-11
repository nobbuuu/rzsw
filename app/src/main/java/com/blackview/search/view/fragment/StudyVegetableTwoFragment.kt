package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.databinding.FragmentStudyVegetableOneBinding
import com.blackview.search.databinding.FragmentStudyVegetableTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyVegetableTwoFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyVegetableTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.vegetables_celery, R.raw.vegetables_coriander, R.raw.vegetables_cabbage, R.raw.vegetables_spinach)
    }

    override fun getForewordRaw(): Int = R.raw.l365dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}