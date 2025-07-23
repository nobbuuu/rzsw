package com.blackview.search.adapter

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blackview.base.kt.ktClick
import com.blackview.base.kt.ktStartActivity
import com.blackview.search.R
import com.blackview.search.bean.HomeItemBean
import com.blackview.search.common.Const
import com.blackview.search.view.activity.StudyExerciseActivity
import com.blackview.search.view.activity.TodaySeekActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.littlejerk.rvdivider.builder.XGridBuilder

class HomeSubjectAdapter : BaseQuickAdapter<HomeItemBean, BaseViewHolder>(R.layout.item_body) {

    private var itemDecoration: RecyclerView.ItemDecoration? = null

    override
    fun convert(holder: BaseViewHolder, item: HomeItemBean) {
        when (holder.itemViewType) {
            Const.VIEW_TYPE_TODAY_SEEK -> {
                holder.itemView.ktClick {
                    context.ktStartActivity(TodaySeekActivity::class)
                }
            }

            Const.VIEW_TYPE_SUBJECT -> {
                val nameTv = holder.getView<TextView>(R.id.nameTv)
                nameTv.text = item.name
                val subjectRv = holder.getView<RecyclerView>(R.id.subjectRv)
                if (itemDecoration == null) {
                    itemDecoration = XGridBuilder(context)
                        .setHLineSpacing(15f)
                        .setVLineSpacing(15f)
                        .setIncludeEdge(false)
                        .setVerticalIncludeEdge(false)
                        .build()
                }
                itemDecoration?.let {
                    subjectRv.removeItemDecoration(it)
                    subjectRv.addItemDecoration(it)
                }
                val subManager = GridLayoutManager(context, 2)
                val subjectAdapter = SubjectAdapter()
                subManager.orientation = GridLayoutManager.HORIZONTAL
                subjectRv.layoutManager = subManager
                subjectRv.adapter = subjectAdapter
                subjectAdapter.setList(item.subject)
                /*holder.itemView.ktClick {
                    context.ktStartActivity(StudyExerciseActivity::class) {
                        putExtra("parentName", item.name)
                        putExtra("parentId", item.id)
                    }
                }*/
            }
        }
    }


    override fun getDefItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            Const.VIEW_TYPE_TODAY_SEEK -> {
                return createBaseViewHolder(parent, R.layout.item_today_seek)
            }

            Const.VIEW_TYPE_SUBJECT -> {
                return createBaseViewHolder(parent, R.layout.item_body)
            }

            Const.VIEW_TYPE_DIVIDER_CONNECT -> {
                return createBaseViewHolder(parent, R.layout.item_divider)

            }
        }
        return createBaseViewHolder(parent, R.layout.item_body)
    }
}