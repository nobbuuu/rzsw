package com.blackview.search.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface SubjectDao {
    @Upsert
    suspend fun insert(subjects: SubjectInfo)

    @Update
    suspend fun update(subjects: SubjectInfo)

    @Delete
    suspend fun delete(subjects: SubjectInfo)

    @Query("SELECT * FROM subjects")
    suspend fun getAllSubjects(): List<SubjectInfo>

    /**
     * 根据detailId更新starNum
     */
    @Query("UPDATE subjects SET starNum = :star WHERE id = :id")
    suspend fun updateStarNum(star: Int, id: String?)
}