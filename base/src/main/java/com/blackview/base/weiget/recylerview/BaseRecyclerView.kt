package com.blackview.base.weiget.recylerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) :RecyclerView(context,attributeSet,defStyleAttr) {

    init {
        layoutManager = LinearLayoutManager(context)
        isVerticalScrollBarEnabled = true
    }
}