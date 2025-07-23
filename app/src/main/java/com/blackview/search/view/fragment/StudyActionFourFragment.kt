package com.blackview.search.view.fragment

import android.view.View
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.core.BaseStudyFragment
import com.blackview.search.databinding.FragmentStudyActionFourBinding
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyActionFourFragment : BaseStudyFragment<StudyExerciseViewModel, FragmentStudyActionFourBinding>() {

    override fun getClickViews(): List<View> {
        return listOf(mBinding.oneIv, mBinding.twoIv, mBinding.threeIv, mBinding.fourIv)
    }

    override fun getContentRaw(): IntArray {
        return intArrayOf(R.raw.l223tp1, R.raw.l223tp2, R.raw.l223tp3, R.raw.l223tp4)
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