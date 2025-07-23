package com.blackview.search.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.blackview.base.kt.ktClick
import com.blackview.base.kt.ktStartActivity
import com.blackview.search.R
import com.blackview.search.bean.ReportStudyBean
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.Const
import com.blackview.search.view.activity.StudyExerciseActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ReportExerciseAdapter :
    BaseQuickAdapter<SubjectBean, BaseViewHolder>(R.layout.item_report_exercise) {
    override fun convert(holder: BaseViewHolder, item: SubjectBean) {
        holder.setText(R.id.levelTv, item.level)
        holder.setText(R.id.nameTv, item.parentName)
        val starsLay = holder.getView<LinearLayout>(R.id.starsLay)
        repeat(item.star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_light)
            starsLay.addView(starIv)
        }

        repeat(3 - item.star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_normal)
            starsLay.addView(starIv)
        }
        val actionIv = holder.getView<ImageView>(R.id.actionIv)
        actionIv.ktClick {
            val intent = Intent(context, StudyExerciseActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("subject", item)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}