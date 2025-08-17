package com.blackview.search.view.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.blackview.base.common.ui.BaseFragment
import com.blackview.search.R
import com.blackview.search.adapter.OrganAdapter
import com.blackview.search.bean.OrganBean
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.base.common.IPlayCallBack
import com.blackview.search.bean.SubjectBean
import com.blackview.search.common.CommonUtils
import com.blackview.search.core.BaseVoiceAgainFragment
import com.blackview.search.databinding.ViewBodyStudyOneBinding
import com.blackview.search.room.AppDatabase
import com.blackview.search.viewmodel.StudyExerciseViewModel
import com.blankj.utilcode.util.StringUtils
import com.littlejerk.rvdivider.builder.XGridBuilder

class StudyBodyOneFragment :
    BaseVoiceAgainFragment<StudyExerciseViewModel, ViewBodyStudyOneBinding>() {
    val organAdapter = OrganAdapter()
    private var subject: SubjectBean? = null
    override fun initView(savedInstanceState: Bundle?) {
        subject = arguments?.getSerializable("subject") as SubjectBean
        val organList = mutableListOf<OrganBean>()
        val eye = OrganBean()
        eye.chName = StringUtils.getString(R.string.organ_eye_ch)
        eye.enName = StringUtils.getString(R.string.organ_eye_en)
        eye.img = R.mipmap.img_eye
        eye.audio_ch = R.raw.my_body_eye
        organList.add(eye)

        val mouth = OrganBean()
        mouth.chName = StringUtils.getString(R.string.organ_mouth_ch)
        mouth.enName = StringUtils.getString(R.string.organ_mouth_en)
        mouth.audio_ch = R.raw.my_body_mouth
        mouth.img = R.mipmap.img_mouth
        organList.add(mouth)

        val nose = OrganBean()
        nose.chName = StringUtils.getString(R.string.organ_nose_ch)
        nose.enName = StringUtils.getString(R.string.organ_nose_en)
        nose.audio_ch = R.raw.my_body_nose
        nose.img = R.mipmap.img_nose
        organList.add(nose)

        val ear = OrganBean()
        ear.chName = StringUtils.getString(R.string.organ_ear_ch)
        ear.enName = StringUtils.getString(R.string.organ_ear_en)
        ear.audio_ch = R.raw.my_body_ear
        ear.img = R.mipmap.img_ear
        organList.add(ear)

        mBinding.organRv.apply {
            adapter = organAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
        organAdapter.setList(organList)
    }

    override fun onResume() {
        super.onResume()
        AudioPlayerManger.playRaw(R.raw.study_body_1_title, object : IPlayCallBack {
            override fun onStart(index: Int) {}
            override fun onEnd(index: Int) {
                val rawRes = intArrayOf(R.raw.my_body_eye, R.raw.my_body_mouth, R.raw.my_body_nose, R.raw.my_body_ear)
                AudioPlayerManger.playRaw(rawRes, object : IPlayCallBack {
                    override fun onStart(index: Int) {
                        organAdapter.notifyItemChanged(index, "start")
                    }

                    override fun onEnd(index: Int) {
                        organAdapter.notifyItemChanged(index, "end")
                        var star = index + 1
                        if (star > 3) {
                            star = 3
                        }
                        subject?.let {
                            it.star = star
                            viewModel.update(star, it.id)
                        }
                    }
                }
                )
            }
        })
    }

    override fun onVoiceAgain() {
        super.onVoiceAgain()
        AudioPlayerManger.stop()
        organAdapter.data.forEachIndexed { index, organBean ->
            organAdapter.notifyItemChanged(index, "end")
        }
        onResume()
    }
}