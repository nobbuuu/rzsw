package com.blackview.search.core

import android.animation.ObjectAnimator
import android.view.View
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class AnimBaseViewHolder(view:View) : BaseViewHolder(view) {
    var animator: ObjectAnimator? = null
}