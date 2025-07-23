package com.blackview.search.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.blackview.search.R
import kotlin.random.Random

class TodaySeekItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.item_seek, this)
        val starLay = findViewById<LinearLayout>(R.id.starLay)
        val random = Random.Default.nextInt(3)
        repeat(random) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_light1)
            starLay.addView(starIv)
        }

        repeat(3 - random) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_normal1)
            starLay.addView(starIv)
        }
    }

    fun resetStar(star: Int) {
        val starLay = findViewById<LinearLayout>(R.id.starLay)
        starLay.removeAllViews()
        repeat(star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_light1)
            starLay.addView(starIv)
        }

        repeat(3 - star) {
            val starIv = ImageView(context)
            starIv.setImageResource(R.mipmap.ic_star_normal1)
            starLay.addView(starIv)
        }
    }
}