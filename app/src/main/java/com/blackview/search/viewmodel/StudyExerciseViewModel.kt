package com.blackview.search.viewmodel

import androidx.lifecycle.MutableLiveData
import com.blackview.base.common.BaseViewModel
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.common.Const.TAG
import com.blackview.search.room.AppDatabase
import com.blackview.search.room.SubjectInfo
import com.blankj.utilcode.util.LogUtils

class StudyExerciseViewModel : BaseViewModel() {
    val allSubjects = MutableLiveData<List<SubjectInfo>>()
    fun insert(subject: SubjectInfo) {
        rxLaunchUI({
            AppDatabase.getInstance().appDataDao().insert(subject)
        })
    }

    fun delete(subject: SubjectInfo) {
        rxLaunchUI({
            AppDatabase.getInstance().appDataDao().delete(subject)
        })
    }

    fun update(subject: SubjectBean) {
        rxLaunchUI({
            AppDatabase.getInstance().appDataDao().update(CommonUtils.convert(subject))
        })
    }

    fun update(starNum: Int, detailId: String?) {
        rxLaunchUI({
            LogUtils.d(TAG, "starNum = $starNum, detailId = $detailId")
            AppDatabase.getInstance().appDataDao().updateStarNum(starNum, detailId)
        })
    }

    fun getAllSubject() {
        rxLaunchUI({
            val data = AppDatabase.getInstance().appDataDao().getAllSubjects()
            allSubjects.postValue(data)
        })
    }

}