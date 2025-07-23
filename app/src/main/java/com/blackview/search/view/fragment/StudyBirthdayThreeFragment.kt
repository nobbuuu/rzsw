package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBirthdayOneBinding
import com.blackview.search.databinding.FragmentStudyBirthdayThreeBinding
import com.blackview.search.databinding.FragmentStudyBirthdayTwoBinding
import com.blackview.search.databinding.FragmentStudyBodyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBirthdayThreeFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBirthdayThreeBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.birthday_party_wand, R.raw.birthday_party_mask, R.raw.birthday_party_ribbon, R.raw.birthday_party_crown)
    }

    override fun getForewordRaw(): Int = R.raw.l291dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}