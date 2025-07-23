package com.blackview.search.common

import com.blackview.search.bean.SubjectBean
import com.blackview.search.room.SubjectInfo

object CommonUtils {
    fun parseStars(failNum: Int): Int {
        if (failNum == 0) {
            return 3
        }
        if (failNum == 1) {
            return 2
        }
        if (failNum > 1) {
            return 1
        }
        return 1
    }

    fun convert(bean: SubjectBean): SubjectInfo {
        val subjectInfo = SubjectInfo()
        subjectInfo.parentId = bean.parentId
        subjectInfo.subjectId = bean.id
        subjectInfo.subjectName = bean.parentName
        subjectInfo.subjectType = bean.type
        subjectInfo.level = bean.level
        subjectInfo.starNum = bean.star
        subjectInfo.id = bean.id.toString()
        subjectInfo.origin = bean.origin
        return subjectInfo
    }

    fun convert(bean: SubjectInfo): SubjectBean {
        val subjectInfo = SubjectBean()
        subjectInfo.parentId = bean.parentId
        subjectInfo.id = bean.id
        subjectInfo.parentName = bean.subjectName
        subjectInfo.type = bean.subjectType
        subjectInfo.level = bean.level
        subjectInfo.star = bean.starNum
        subjectInfo.origin = bean.origin
        return subjectInfo
    }
}