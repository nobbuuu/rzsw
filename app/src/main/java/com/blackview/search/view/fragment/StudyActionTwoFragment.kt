package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyActionTwoBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyActionTwoFragment : BaseStudyFragment<StudyExerciseViewModel, FragmentStudyActionTwoBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.sitIv, mBinding.standIv, mBinding.walkIv, mBinding.runIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.my_actions_sit, R.raw.my_actions_stand, R.raw.my_actions_walk, R.raw.my_actions_run)
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