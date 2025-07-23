package com.blackview.search.bean

import java.io.Serializable

data class HomeItemBean(
    val name: String? = "",
    val subject: MutableList<SubjectBean>? = null,
    val type: Int = 0,
    val id: Int = 0
) : Serializable


data class SubjectBean(
    var key: Int = 0,
    var star: Int = 0,
    var name: String? = null,
    var resId: Int = 0,
    var level: String? = "",
    var parentName: String? = null,
    var id: String? = "",
    var parentId: String? = "",
    var type: SubjectType? = null,
    var origin: Int = 0
) : Serializable