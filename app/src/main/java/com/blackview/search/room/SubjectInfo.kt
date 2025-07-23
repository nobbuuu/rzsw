package com.blackview.search.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.blackview.search.bean.SubjectType
import java.util.UUID

@Entity(tableName = "subjects")
data class SubjectInfo(
    @PrimaryKey(autoGenerate = false) var id: String = "",
    @ColumnInfo
    var level: String? = "",
    @ColumnInfo
    var subjectName: String? = "",
    @ColumnInfo
    var subjectId: String? = "",
    @ColumnInfo
    var subjectType: SubjectType? = null,
    @ColumnInfo
    var starNum: Int = 0,
    @ColumnInfo
    var origin: Int = 0,
    @ColumnInfo
    var parentId: String? = "",
    @ColumnInfo
    var extra: String? = "",
)