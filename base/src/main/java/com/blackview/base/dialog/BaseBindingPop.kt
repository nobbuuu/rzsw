package com.blackview.base.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.*
import android.widget.PopupWindow
import androidx.viewbinding.ViewBinding
import com.blackview.base.R
import java.lang.reflect.ParameterizedType

open class BaseBindingPop<B : ViewBinding>(context: Activity) : PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) {
    protected lateinit var mBinding: B
    init {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val cls = type.actualTypeArguments[type.actualTypeArguments.size - 1] as Class<*>
            when {
                ViewBinding::class.java.isAssignableFrom(cls) -> {
                    cls.getDeclaredMethod("inflate", LayoutInflater::class.java).let {
                        @Suppress("UNCHECKED_CAST")
                        mBinding = it.invoke(null, context.layoutInflater) as B
                        contentView = mBinding.root
                        isFocusable = false
                        isOutsideTouchable = true
                        setBackgroundDrawable(BitmapDrawable())
                    }
                }
            }
        } else throw IllegalArgumentException("Generic error")
    }
}