package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyConcertBinding
import com.blackview.search.databinding.FragmentStudyConcertThreeBinding
import com.blackview.search.databinding.FragmentStudyConcertTwoBinding
import com.blackview.search.databinding.FragmentStudyFruitBinding
import com.blackview.search.databinding.FragmentStudyNutBinding
import com.blackview.search.databinding.FragmentStudySupermarketOneBinding
import com.blackview.search.databinding.FragmentStudySupermarketTwoBinding
import com.blackview.search.databinding.FragmentStudyVegetableOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyConcertThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyConcertThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.threeIv, mBinding.twoIv, mBinding.oneIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.music_concert_harp, R.raw.music_concert_accordion, R.raw.music_concert_tambourine, R.raw.music_concert_drum_kit)
    }

    override fun getForewordRaw(): Int = R.raw.l381dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}