package com.blackview.search.bean

import android.view.View

data class Step(
    val audioResId: Int,
    val correctOrgan: String,
    val targetImage: View? = null
)