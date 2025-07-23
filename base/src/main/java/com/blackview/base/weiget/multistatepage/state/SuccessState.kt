package com.blackview.base.weiget.multistatepage.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.blackview.base.weiget.multistatepage.MultiState
import com.blackview.base.weiget.multistatepage.MultiStateContainer

/**
 * @author : tiaozi
 * time : 2020/11/17 9:34
 */
class SuccessState : MultiState() {
    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return View(context)
    }

    override fun onMultiStateViewCreate(view: View) = Unit

}