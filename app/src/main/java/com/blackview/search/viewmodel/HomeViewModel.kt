package com.blackview.search.viewmodel

import androidx.lifecycle.MutableLiveData
import com.blackview.base.common.BaseViewModel
import com.blackview.search.App
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const.TAG
import com.blackview.search.common.HHTManager
import com.blackview.search.room.AppDatabase
import com.blackview.search.room.SubjectInfo
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class HomeViewModel : BaseViewModel() {

    val subjects = MutableLiveData<List<SubjectInfo>>()

    fun queryDataBase() {
        rxLaunchUI({
            val list = AppDatabase.getInstance().appDataDao().getAllSubjects()
            LogUtils.dTag(TAG,"room data size = ${list.size}")
            LogUtils.dTag(TAG,"room data = ${GsonUtils.toJson(list)}")
            subjects.postValue(list)
        }, showDialog = false)
    }

    fun insert(subjectBean: SubjectBean) {
        rxLaunchUI({
            AppDatabase.getInstance().appDataDao().insert(CommonUtils.convert(subjectBean))
        })
    }
}