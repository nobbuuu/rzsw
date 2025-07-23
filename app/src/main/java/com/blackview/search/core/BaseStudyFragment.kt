package com.blackview.search.core

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.blackview.base.common.BaseViewModel
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.common.ui.BaseFragment
import com.blackview.base.kt.ktAnimScale
import com.blackview.base.kt.ktClick
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.R
import com.blackview.search.bean.SubjectBean
import com.blackview.search.view.activity.StudyExerciseActivity

abstract class BaseStudyFragment<VM : BaseViewModel, DB : ViewBinding> :
    BaseVoiceAgainFragment<VM, DB>() {
    val viewAnimMap = HashMap<View, ObjectAnimator>()
    private val clickViews: MutableList<View> = mutableListOf()
    override fun initView(savedInstanceState: Bundle?) {
        val raw = getContentRaw()
        val views = getClickViews()
        clickViews.clear()
        clickViews.addAll(views)
        clickViews.forEachIndexed { index, it ->
            initViewAnim(it)
            it.ktClick {
                if (raw.size > index) {
                    onPerformClick(raw[index], it)
                }
            }
        }
    }

    fun onPerformClick(rawId: Int, view: View) {
        viewAnimMap.forEach {
            it.value.cancel()
        }
        view.ktAnimScale(rawId, viewAnimMap.get(view))
    }

    override fun onResume() {
        super.onResume()
        viewAnimMap.forEach {
            it.value.cancel()
        }
        AudioPlayerManger.stop()
        AudioPlayerManger.playRaw(getForewordRaw(), object : IPlayCallBack {
            override fun onStart(index: Int) {}
            override fun onEnd(index: Int) {
                AudioPlayerManger.playRaw(
                    getContentRaw(), object : IPlayCallBack {
                        override fun onStart(index: Int) {
                            when (index) {
                                0 -> {
                                    viewAnimMap.get(clickViews[0])?.start()
                                }

                                1 -> {
                                    viewAnimMap.get(clickViews[1])?.start()
                                }

                                2 -> {
                                    viewAnimMap.get(clickViews[2])?.start()
                                }

                                3 -> {
                                    viewAnimMap.get(clickViews[3])?.start()
                                }
                            }
                        }

                        override fun onEnd(index: Int) {
                            when (index) {
                                0 -> {
                                    viewAnimMap.get(clickViews[0])?.cancel()
                                }

                                1 -> {
                                    viewAnimMap.get(clickViews[1])?.cancel()
                                }

                                2 -> {
                                    viewAnimMap.get(clickViews[2])?.cancel()
                                }

                                3 -> {
                                    viewAnimMap.get(clickViews[3])?.cancel()
                                }
                            }
                            var star = index + 1
                            if (star > 3) {
                                star = 3
                            }
                            updateStar(star)
                        }
                    }
                )
            }
        })
    }

    fun initViewAnim(view: View) {
        // 创建缩放动画
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.1f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.1f)
        var animator = ObjectAnimator.ofPropertyValuesHolder(
            view,
            scaleX,
            scaleY
        ).apply {
            this.duration = 400
            startDelay = 0
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            interpolator = LinearInterpolator()
        }
        viewAnimMap.put(view, animator)
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        onResume()
    }

    abstract fun getClickViews(): List<View>
    abstract fun getContentRaw(): IntArray
    abstract fun getForewordRaw(): Int
    abstract fun updateStar(star: Int)
}