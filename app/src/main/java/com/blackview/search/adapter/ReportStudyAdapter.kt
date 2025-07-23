package com.blackview.search.adapter

import com.blackview.search.R
import com.blackview.search.bean.ReportStudyBean
import com.blackview.search.common.Const
import com.blackview.search.widget.CustomProgressBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ReportStudyAdapter :
    BaseQuickAdapter<ReportStudyBean, BaseViewHolder>(R.layout.item_report_study) {
    override fun convert(holder: BaseViewHolder, item: ReportStudyBean) {
        when (item.level) {
            Const.KEY_LEVEL_ONE -> {
                holder.setImageResource(R.id.levelIv, R.mipmap.ic_report_level1)
            }

            Const.KEY_LEVEL_TWO -> {
                holder.setImageResource(R.id.levelIv, R.mipmap.ic_report_level2)
            }

            Const.KEY_LEVEL_THREE -> {
                holder.setImageResource(R.id.levelIv, R.mipmap.ic_report_level3)
            }
        }
        holder.setText(R.id.progressTv, "完成了${item.stars}个主题知识的学习，共${item.total}个")
        holder.setText(R.id.percentTv, "${item.progress}%")
        val studyProgressBar = holder.getView<CustomProgressBar>(R.id.studyProgressBar)
        studyProgressBar.max = item.total
        studyProgressBar.progress = item.stars
    }
}