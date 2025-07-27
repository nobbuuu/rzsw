package com.blackview.search.view.activity

import android.os.Bundle
import android.view.ViewGroup
import com.blackview.base.common.ui.BaseActivity
import com.blackview.base.kt.dp
import com.blackview.base.kt.ktClick
import com.blackview.base.kt.ktStartActivity
import com.blackview.search.R
import com.blackview.search.adapter.HomeSubjectAdapter
import com.blackview.search.bean.HomeItemBean
import com.blackview.search.bean.SubjectBean
import com.blackview.search.bean.SubjectType
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const
import com.blackview.search.common.HHTManager
import com.blackview.search.databinding.ActivityHomeBinding
import com.blackview.search.room.AppDatabase
import com.blackview.search.viewmodel.HomeViewModel
import com.blankj.utilcode.util.LogUtils
import java.util.UUID
import kotlin.random.Random

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {
    var curLevel = "L1"
    private val resIds = listOf<Int>(
        R.mipmap.img_body_item_eg1,
        R.mipmap.img_body_item_eg3,
        R.mipmap.img_body_item_eg2,
        R.mipmap.img_body_item_eg4
    )
    private val l1StrList = listOf<String>(
        "我的身体",
        "情绪和感觉",
        "我的动作",
        "玩具房",
        "客厅",
        "卧室",
        "衣服",
        "书房",
        "厨房",
        "浴室",
        "洗衣房",
        "生日派对"
    )
    private val l2StrList = listOf<String>(
        "街道",
        "交通",
        "建筑工地",
        "医院",
        "学校",
        "职业",
        "超市",
        "超市-蔬菜",
        "超市-水果",
        "超市-坚果",
        "音乐会",
        "游乐场",
        "安全标识"
    )
    private val l3StrList = listOf<String>(
        "天气",
        "农场",
        "乡村",
        "露营",
        "爬山",
        "植物园",
        "动物园",
        "海洋馆",
        "天文馆",
        "海滩",
        "体育馆",
        "港口",
        "机场",
        "建筑"
    )
    private val mAdapter = HomeSubjectAdapter()
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.scrollBar.initBars(R.mipmap.scrollbar_bg, R.mipmap.scrollbar_indicator)
        mBinding.scrollBar.bindRecyclerView(mBinding.l1Rv)
        resetModelL1()
        mBinding.LRadioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbl1 -> {
                    resetModelL1()
                }

                R.id.rbl2 -> {
                    resetModelL2()
                }

                R.id.rbl3 -> {
                    resetModelL3()
                }
            }
        }

        mBinding.l1Rv.apply {
            adapter = mAdapter
        }

    }

    private fun resetModelL1() {
        val rbl1LayParams = mBinding.rbl1.layoutParams
        rbl1LayParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        mBinding.rbl1.layoutParams = rbl1LayParams
        val rbl2LayParams = mBinding.rbl2.layoutParams
        rbl2LayParams.height = 35.dp.toInt()
        mBinding.rbl2.layoutParams = rbl2LayParams
        val rbl3LayParams = mBinding.rbl3.layoutParams
        rbl3LayParams.height = 35.dp.toInt()
        mBinding.rbl3.layoutParams = rbl3LayParams
        curLevel = "L1"
        setData()
    }

    private fun resetModelL2() {
        val rbl2LayParams = mBinding.rbl2.layoutParams
        rbl2LayParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        mBinding.rbl2.layoutParams = rbl2LayParams
        val rbl1LayParams = mBinding.rbl1.layoutParams
        rbl1LayParams.height = 35.dp.toInt()
        mBinding.rbl1.layoutParams = rbl1LayParams
        val rbl3LayParams = mBinding.rbl3.layoutParams
        rbl3LayParams.height = 35.dp.toInt()
        mBinding.rbl3.layoutParams = rbl3LayParams
        curLevel = "L2"
        setData()
    }

    private fun resetModelL3() {
        val rbl3LayParams = mBinding.rbl3.layoutParams
        rbl3LayParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        mBinding.rbl3.layoutParams = rbl3LayParams
        val rbl2LayParams = mBinding.rbl2.layoutParams
        rbl2LayParams.height = 35.dp.toInt()
        mBinding.rbl2.layoutParams = rbl2LayParams
        val rbl1LayParams = mBinding.rbl1.layoutParams
        rbl1LayParams.height = 35.dp.toInt()
        mBinding.rbl1.layoutParams = rbl1LayParams
        curLevel = "L3"
        setData()
    }

    override fun initData() {
    }

    override fun onResume() {
        super.onResume()
        viewModel.queryDataBase()
    }

    override fun onEvent() {
        super.onEvent()
        mBinding.backIv.ktClick {
            finish()
        }
        viewModel.subjects.observe(this) {
            setData()
        }
        mBinding.reportIv.ktClick {
            ktStartActivity(StudyReportActivity::class)
        }
        mBinding.knowCardIv.ktClick {
            ktStartActivity(KnowCardActivity::class)
        }
    }

    fun setData() {
        viewModel.subjects.value?.let {
            val homeList = mutableListOf<HomeItemBean>()
            val homeStrList = mutableListOf<String>()
            homeList.add(HomeItemBean(type = Const.VIEW_TYPE_TODAY_SEEK))
            homeList.add(HomeItemBean(type = Const.VIEW_TYPE_DIVIDER_CONNECT))
            when (curLevel) {
                Const.KEY_LEVEL_ONE -> {
                    homeStrList.addAll(l1StrList)
                }

                Const.KEY_LEVEL_TWO -> {
                    homeStrList.addAll(l2StrList)
                }

                Const.KEY_LEVEL_THREE -> {
                    homeStrList.addAll(l3StrList)
                }
            }
            homeStrList.forEachIndexed { parentIndex, parentName ->
                val subjects = mutableListOf<SubjectBean>()
                resIds.forEachIndexed { index, resId ->
                    val origin = index + 1
                    val studyId =
                        curLevel + parentIndex.toString() + origin.toString() + SubjectType.STUDY.ordinal.toString()
                    val exerciseId =
                        curLevel + parentIndex.toString() + origin.toString() + SubjectType.EXERCISE.ordinal.toString()
                    val subjectStudy = SubjectBean(
                        id = studyId,
                        resId = resId,
                        parentId = parentIndex.toString(),
                        parentName = parentName,
                        type = SubjectType.STUDY,
                        level = curLevel,
                        origin = origin,
                        star = it.find { it.id == studyId }?.starNum ?: 0
                    )
                    val subjectExercise = SubjectBean(
                        id = exerciseId,
                        resId = resId,
                        parentId = parentIndex.toString(),
                        parentName = parentName,
                        type = SubjectType.EXERCISE,
                        level = curLevel,
                        origin = origin,
                        star = it.find { it.id == exerciseId }?.starNum ?: 0
                    )
                    viewModel.insert(subjectStudy)
                    viewModel.insert(subjectExercise)
                    subjects.add(subjectExercise)
                }

                val homeItem =
                    HomeItemBean(parentName, subjects, Const.VIEW_TYPE_SUBJECT, id = parentIndex)
                homeList.add(homeItem)
                if (parentIndex != l1StrList.size - 1) {
                    homeList.add(HomeItemBean(type = Const.VIEW_TYPE_DIVIDER_CONNECT))
                }
            }
            mAdapter.setList(homeList)
        }
    }

}