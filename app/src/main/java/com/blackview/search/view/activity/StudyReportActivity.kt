package com.blackview.search.view.activity

import android.os.Bundle
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import com.blackview.base.common.ui.BaseActivity
import com.blackview.base.kt.dp
import com.blackview.base.kt.ktClick
import com.blackview.search.R
import com.blackview.search.adapter.ReportExerciseAdapter
import com.blackview.search.adapter.ReportStudyAdapter
import com.blackview.search.bean.ReportStudyBean
import com.blackview.search.bean.SubjectBean
import com.blackview.search.bean.SubjectType
import com.blackview.search.common.CommonUtils
import com.blackview.search.databinding.ActivityStudyReportBinding
import com.blackview.search.databinding.ActivityTodaySeekBinding
import com.blackview.search.viewmodel.StudyReportViewModel
import com.blackview.search.viewmodel.TodaySeekViewModel
import kotlin.math.roundToInt

class StudyReportActivity : BaseActivity<StudyReportViewModel, ActivityStudyReportBinding>() {

    val studyList = mutableListOf<ReportStudyBean>()
    val exerciseList = mutableListOf<SubjectBean>()
    var subjectType = SubjectType.STUDY
    val studyAdapter = ReportStudyAdapter()
    val exerciseAdapter = ReportExerciseAdapter()
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.backIv.ktClick {
            finish()
        }
        resetStudy()
    }

    override fun initData() {
        mBinding.LRadioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbl1 -> {
                    resetStudy()
                }

                R.id.rbl2 -> {
                    resetExercise()
                }
            }
        }
        viewModel.queryAllSubjects()

    }

    override fun startObserve() {
        super.startObserve()
        viewModel.subjects.observe(this) {
            studyList.add(buildStudyBean("L1"))
            studyList.add(buildStudyBean("L2"))
            studyList.add(buildStudyBean("L3"))
            studyAdapter.setList(studyList)
            val exercises = it.filter { it.subjectType == SubjectType.EXERCISE && it.starNum > 0 }
            exerciseList.clear()
            exercises.forEach {
                exerciseList.add(CommonUtils.convert(it))
            }
            exerciseAdapter.setList(exerciseList)
        }
    }

    fun buildStudyBean(level: String): ReportStudyBean {
        viewModel.subjects.value?.let {
            val subjects = it.filter { it.level == level }
            val alreadyStudy = subjects.filter { it.starNum > 0 }
            val progress = calculatePercentage(alreadyStudy.size, subjects.size)
            val studyBean = ReportStudyBean(level, subjects.size, alreadyStudy.size, progress)
            return studyBean
        }
        return ReportStudyBean(level, 0, 0, 0)
    }

    fun calculatePercentage(a: Int, b: Int): Int {
        if (b == 0) return 0 // 避免除零错误
        return (a * 100.0 / b).roundToInt() // 转换为百分比后四舍五入取整
    }

    private fun resetStudy() {
        val rbl1LayParams = mBinding.rbl1.layoutParams
        rbl1LayParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        mBinding.rbl1.layoutParams = rbl1LayParams
        val rbl2LayParams = mBinding.rbl2.layoutParams
        rbl2LayParams.width = 38.dp.toInt()
        mBinding.rbl2.layoutParams = rbl2LayParams
        mBinding.headLay.root.isGone = true
        val rvParams = mBinding.studyReportRv.layoutParams as ConstraintLayout.LayoutParams
        rvParams.topMargin = 100.dp.toInt()
        mBinding.studyReportRv.layoutParams = rvParams
        subjectType = SubjectType.STUDY
        mBinding.studyReportRv.adapter = studyAdapter
        studyAdapter.setList(studyList)
    }

    private fun resetExercise() {
        val rbl2LayParams = mBinding.rbl2.layoutParams
        rbl2LayParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        mBinding.rbl2.layoutParams = rbl2LayParams
        val rbl1LayParams = mBinding.rbl1.layoutParams
        rbl1LayParams.width = 38.dp.toInt()
        mBinding.rbl1.layoutParams = rbl1LayParams
        val rvParams = mBinding.studyReportRv.layoutParams as ConstraintLayout.LayoutParams
        rvParams.topMargin = 134.dp.toInt()
        mBinding.studyReportRv.layoutParams = rvParams
        mBinding.headLay.root.isGone = false
        subjectType = SubjectType.EXERCISE
        mBinding.studyReportRv.adapter = exerciseAdapter
        exerciseAdapter.setList(exerciseList)
    }

}