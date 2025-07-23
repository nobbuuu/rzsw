package com.blackview.search.view.activity

import android.os.Bundle
import com.blackview.base.common.ui.BaseActivity
import com.blackview.base.kt.ktClick
import com.blackview.search.databinding.ActivityTodaySeekBinding
import com.blackview.search.viewmodel.TodaySeekViewModel

class TodaySeekActivity : BaseActivity<TodaySeekViewModel, ActivityTodaySeekBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.backIv.ktClick {
            finish()
        }
    }

    override fun initData() {

    }
}