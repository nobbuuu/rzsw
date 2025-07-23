package com.blackview.search.viewmodel

import androidx.lifecycle.MutableLiveData
import com.blackview.base.common.BaseViewModel
import com.blackview.search.room.AppDatabase
import com.blackview.search.room.SubjectInfo

class StudyReportViewModel : BaseViewModel() {

    val subjects = MutableLiveData<List<SubjectInfo>>()
    fun queryAllSubjects() {
        rxLaunchUI({
            val list = AppDatabase.getInstance().appDataDao().getAllSubjects()
            subjects.postValue(list)
        })
    }
}