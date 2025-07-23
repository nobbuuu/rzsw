package com.blackview.search.view.activity

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import com.blackview.base.common.ui.BaseActivity
import com.blackview.base.kt.dp
import com.blackview.base.kt.ktClick
import com.blackview.search.R
import com.blackview.search.bean.SubjectType
import com.blackview.search.databinding.ActivityKnowCardBinding
import com.blackview.search.viewmodel.HomeViewModel

class KnowCardActivity : BaseActivity<HomeViewModel, ActivityKnowCardBinding>() {
    var curLevel = "L1"
    private val cardRes = intArrayOf(R.mipmap.img_pt_1, R.mipmap.img_pt_2, R.mipmap.img_pt_3, R.mipmap.img_pt_4, R.mipmap.img_pt_5, R.mipmap.img_pt_6, R.mipmap.img_pt_7,
        R.mipmap.img_pt_8, R.mipmap.img_pt_9, R.mipmap.img_pt_10, R.mipmap.img_pt_11, R.mipmap.img_pt_12, R.mipmap.img_pt_13, R.mipmap.img_pt_14, R.mipmap.img_pt_15,
        R.mipmap.img_pt_16, R.mipmap.img_pt_17, R.mipmap.img_pt_18, R.mipmap.img_pt_19, R.mipmap.img_pt_20, R.mipmap.img_pt_21, R.mipmap.img_pt_22, R.mipmap.img_pt_23,
        R.mipmap.img_pt_24, R.mipmap.img_pt_25, R.mipmap.img_pt_26, R.mipmap.img_pt_27, R.mipmap.img_pt_28)
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.backIv.ktClick {
            finish()
        }
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
        cardRes.forEach {
            val imageView = ImageView(this)
            imageView.setImageResource(it)
            mBinding.cardLay.addView(imageView)
        }
    }

    override fun initData() {
        viewModel.queryDataBase()
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
    }

    override fun startObserve() {
        super.startObserve()
        viewModel.subjects.observe(this) {
            val starts = it.filter { it.subjectType == SubjectType.EXERCISE }.sumOf { it.starNum }
            mBinding.starsTv.text = "$starts"
        }
    }
}