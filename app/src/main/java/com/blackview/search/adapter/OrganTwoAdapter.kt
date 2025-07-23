package com.blackview.search.adapter

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.blackview.base.kt.ktClick
import com.blackview.search.R
import com.blackview.search.bean.OrganBean
import com.blackview.search.core.AnimBaseViewHolder
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.base.common.IPlayCallBack
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.BaseQuickAdapter

class OrganTwoAdapter :
    BaseQuickAdapter<OrganBean, AnimBaseViewHolder>(R.layout.item_body_organ_h) {

    override fun convert(holder: AnimBaseViewHolder, item: OrganBean) {
        holder.setImageResource(R.id.organIv, item.img)
        holder.setText(R.id.chNameTv, item.chName)
        holder.setText(R.id.enNameTv, item.enName)
        val organIv = holder.getView<ImageView>(R.id.organIv)
        organIv.ktClick {
            holder.animator?.cancel()
            holder.animator = null
            data.forEachIndexed { index, organBean ->
                if (index != holder.adapterPosition) {
                    notifyItemChanged(index, "end")
                }
            }
            AudioPlayerManger.playRaw(item.audio_ch, object : IPlayCallBack {
                override fun onStart(index: Int) {
                    notifyItemChanged(holder.adapterPosition, "start")
                }

                override fun onEnd(index: Int) {
                    notifyItemChanged(holder.adapterPosition, "end")
                }
            })
        }
    }

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): AnimBaseViewHolder {
        var layoutId = R.layout.item_body_organ_h
        if (viewType == 2){
            layoutId = R.layout.item_body_organ_r
        }
        return AnimBaseViewHolder(
            LayoutInflater.from(context).inflate(layoutId, parent, false)
        )
    }

    override fun getDefItemViewType(position: Int): Int {
        return if (position == 1 || position == 3) {
            2
        } else {
            1
        }
    }

    override fun convert(holder: AnimBaseViewHolder, item: OrganBean, payloads: List<Any>) {
        super.convert(holder, item, payloads)
        val organIv = holder.getView<ImageView>(R.id.organIv)
        if (payloads.first().toString() == "start") {
            holder.animator = null
            // 创建缩放动画
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.2f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.2f)
            val animator = ObjectAnimator.ofPropertyValuesHolder(
                organIv,
                scaleX,
                scaleY
            ).apply {
                duration = 500
                startDelay = 0
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
                interpolator = LinearInterpolator()
            }
            animator.start()
            holder.animator = animator
            LogUtils.dTag("axiba", "payloads....start")
        } else if (payloads.first().toString() == "end") {
            LogUtils.dTag("axiba", "payloads....end")
            holder.animator?.cancel()
            holder.animator = null
        }
    }

}