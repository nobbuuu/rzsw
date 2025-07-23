package com.blackview.search.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.blackview.search.R

/**
 * @Description:
 * @Date: 2024/6/3 13:41
 * @author:  wangwanjiang
 * @version: 1.0
 */
class RecyclerViewScrollBar : FrameLayout {

    private val TAG = "RecyclerViewScrollBar"

    private var recyclerView: RecyclerView? = null
    private lateinit var imgBg: ImageView

    private lateinit var imgIndicator: ImageView

    constructor(context: Context) : this(context, null, -1)
    constructor(context: Context, attributes: AttributeSet?) : this(context, attributes, -1)
    constructor(context: Context, attributes: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributes,
        defStyleAttr
    ) {
        initView(context)
    }

    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.view_recycler_scroll_bar, this, true)

        imgBg = findViewById(R.id.imgBg)
        imgIndicator = findViewById(R.id.imgIndicator)
    }

    fun bindRecyclerView(recyclerView: RecyclerView?) {
        this.recyclerView = recyclerView
        if (this.recyclerView == null) {
            return
        }

        this.recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val imgBgHeight = imgBg.measuredWidth
                val imgIndicatorHeight = imgIndicator.measuredWidth

                val computeVerticalScrollRange = recyclerView.computeHorizontalScrollRange().toFloat()
                val computeVerticalScrollOffset = recyclerView.computeHorizontalScrollOffset().toFloat()

                val height = recyclerView.measuredWidth

                val maxdy =
                    (computeVerticalScrollRange - height) / computeVerticalScrollRange

                val temp = computeVerticalScrollOffset / computeVerticalScrollRange / maxdy


                imgIndicator.translationX = (imgBgHeight - imgIndicatorHeight) * temp

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

    }

    fun initBars(bgColor: Int, indicatorColor: Int) {
        imgBg.setImageResource(bgColor)
        imgIndicator.setImageResource(indicatorColor)
    }
}