package com.blackview.base.weiget.multistatepage.state

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.blackview.base.R
import com.blackview.base.weiget.multistatepage.MultiState
import com.blackview.base.weiget.multistatepage.MultiStateContainer
import com.blackview.base.weiget.multistatepage.MultiStatePage

/**
 * @author : tiaozi
 * time : 2020/11/17 9:34
 */
class EmptyState : MultiState() {

    private lateinit var tvEmptyMsg: TextView
    private lateinit var imgEmpty: ImageView

    override fun onCreateMultiStateView(
        context: Context,
        inflater: LayoutInflater,
        container: MultiStateContainer
    ): View {
        return inflater.inflate(R.layout.mult_state_empty, container, false)
    }

    override fun onMultiStateViewCreate(view: View) {
        tvEmptyMsg = view.findViewById(R.id.tv_empty_msg)
        imgEmpty = view.findViewById(R.id.img_empty)

        setEmptyMsg(MultiStatePage.config.emptyMsg)
        setEmptyIcon(MultiStatePage.config.emptyIcon)
    }


    override fun bindRetryView(): View? {
        return tvEmptyMsg
    }

    fun setEmptyMsg(emptyMsg: String) {
        tvEmptyMsg.text = emptyMsg
    }

    fun setEmptyIcon(@DrawableRes emptyIcon: Int) {
        imgEmpty.setImageResource(emptyIcon)
    }
}