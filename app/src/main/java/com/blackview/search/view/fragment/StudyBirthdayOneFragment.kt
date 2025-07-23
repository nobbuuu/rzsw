package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyBirthdayOneBinding
import com.blackview.search.databinding.FragmentStudyBodyFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyBirthdayOneFragment :
    BaseStudyFragment<StudyExerciseViewModel, FragmentStudyBirthdayOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.birthday_party_balloon, R.raw.birthday_party_birthday_cake, R.raw.birthday_party_gift, R.raw.birthday_party_candle)
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