package com.blackview.base.dialog

import android.content.Context
import com.blackview.base.databinding.CustomProgressDialogViewBinding

class LoadingDialog(context: Context) : BaseBindingDialog<CustomProgressDialogViewBinding>(context, styleRes = 0) {
    init {
        setCancelable(false)
    }
}