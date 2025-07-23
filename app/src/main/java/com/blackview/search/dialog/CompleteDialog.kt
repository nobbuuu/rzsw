package com.blackview.search.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.blackview.base.databinding.CustomProgressDialogViewBinding
import com.blackview.base.dialog.BaseBindingDialog
import com.blackview.base.kt.ktClick
import com.blackview.search.R
import com.blackview.search.common.Const
import com.blackview.search.databinding.DialogCompleteBinding
import com.blackview.search.room.AppDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompleteDialog(
    context: Context,
    val id: String? = "",
    val star: Int,
    val onAction: ((String) -> Unit)? = null
) :
    BaseBindingDialog<DialogCompleteBinding>(context, styleRes = 0) {

    var originStar = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(true)
        mBinding.btnRetry.ktClick {
            dismiss()
            onAction?.invoke("retry")
        }
        mBinding.btnNext.ktClick {
            dismiss()
            onAction?.invoke("next")
        }
        GlobalScope.launch {
            val allSubjects = AppDatabase.getInstance().appDataDao().getAllSubjects()
            val starts = allSubjects.sumOf { it.starNum }
            originStar = starts
            mBinding.starsTv.post {
                mBinding.starsTv.text = "$starts"
                val starNum = allSubjects.find { it.id == id }?.starNum ?: 0
                refreshStar(star, starNum == Const.KEY_FULL_MARKS && star == Const.KEY_FULL_MARKS)
            }
            onAction?.invoke("update")
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun refreshStar(star: Int, isFullMarks: Boolean = false) {
        when (star) {
            1 -> {
                if (isFullMarks) {
                    mBinding.starIv.setImageResource(R.mipmap.gif_caihong)
                } else {
                    mBinding.starIv.setImageDrawable(context.getDrawable(R.drawable.anim_star1))
                    mBinding.starAddIv.setImageDrawable(context.getDrawable(R.drawable.anim_star_add1))
                }
            }

            2 -> {
                if (isFullMarks) {
                    mBinding.starIv.setImageResource(R.mipmap.gif_caihong)
                } else {
                    mBinding.starIv.setImageDrawable(context.getDrawable(R.drawable.anim_star2))
                    mBinding.starAddIv.setImageDrawable(context.getDrawable(R.drawable.anim_star_add2))
                }
            }

            3 -> {
                if (isFullMarks) {
                    mBinding.starIv.setImageResource(R.mipmap.gif_caihong)
                } else {
                    mBinding.starIv.setImageDrawable(context.getDrawable(R.drawable.anim_star3))
                    mBinding.starAddIv.setImageDrawable(context.getDrawable(R.drawable.anim_star_add3))
                }
            }
        }

        if (!isFullMarks) {
            val anim = mBinding.starIv.drawable as AnimationDrawable
            val animAdd = mBinding.starAddIv.drawable as AnimationDrawable
            mBinding.starIv.post {
                anim.start()
                mBinding.starAddIv.postDelayed({
                    mBinding.starAddIv.isVisible = true
                    animAdd.start()
                    mBinding.starAddIv.postDelayed({
                        mBinding.starAddIv.isInvisible = true
                    }, 100 * 27)
                    repeat(star) {
                        mBinding.starAddIv.postDelayed({
                            mBinding.starsTv.text = "${originStar++}"
                        }, ((100 * 27) / star).toLong())
                    }
                }, 100 * 25)
            }
        }
    }
}