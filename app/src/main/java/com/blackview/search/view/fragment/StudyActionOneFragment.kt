package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyActionOneBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyActionOneFragment : BaseStudyFragment<StudyExerciseViewModel, FragmentStudyActionOneBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.speakIv1, mBinding.speakIv2, mBinding.eatIv, mBinding.drinkIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.my_actions_speak, R.raw.my_actions_sing, R.raw.my_actions_eat, R.raw.my_actions_drink)
    }

    override fun getForewordRaw(): Int = R.raw.l217dr

    override fun updateStar(star: Int) {
        val subject = arguments?.getSerializable("subject") as SubjectBean
        subject.let {
            it.star = star
            viewModel.update(star, it.id)
        }
    }
}