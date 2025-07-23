package com.blackview.search.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isGone
import com.blackview.base.kt.ktClick
import com.blackview.base.kt.ktStartActivity
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.view.activity.StudyExerciseActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class SubjectAdapter() :
    BaseQuickAdapter<SubjectBean, BaseViewHolder>(R.layout.item_subject) {
    override fun convert(holder: BaseViewHolder, item: SubjectBean) {
        holder.setImageResource(R.id.subjectIv, item.resId)
        val starLay = holder.getView<LinearLayout>(R.id.starLay)
        starLay.isGone = item.star == 0
        repeat(item.star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_light)
            starLay.addView(starIv)
        }

        repeat(3 - item.star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_normal)
            starLay.addView(starIv)
        }
        holder.itemView.ktClick {
            val intent = Intent(context,StudyExerciseActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("subject", item)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}