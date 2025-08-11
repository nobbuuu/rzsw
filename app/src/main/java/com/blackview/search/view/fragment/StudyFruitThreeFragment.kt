package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyFruitBinding
import com.blackview.search.databinding.FragmentStudyFruitThreeBinding
import com.blackview.search.databinding.FragmentStudyFruitTwoBinding
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.databinding.FragmentStudyVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyFruitThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyFruitThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.fruits_avocado, R.raw.fruits_guava, R.raw.fruits_pitaya, R.raw.fruits_kiwi_fruit)
    }

    override fun getForewordRaw(): Int = R.raw.l373dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}