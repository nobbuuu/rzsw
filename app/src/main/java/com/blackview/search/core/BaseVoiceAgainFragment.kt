package com.blackview.search.core

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.blackview.base.common.BaseViewModel
import com.blackview.base.common.ui.BaseFragment
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.view.activity.StudyExerciseActivity

open class BaseVoiceAgainFragment<VM : BaseViewModel, DB : ViewBinding> : BaseFragment<VM,DB>(), VoiceAgainInterface {

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun onResume() {
        super.onResume()
        (activity as? StudyExerciseActivity)?.registerFragmentListener(this)
    }

    override fun onPause() {
        super.onPause()
        AudioPlayerManger.pause()
        (activity as? StudyExerciseActivity)?.unregisterFragmentListener()
    }

    override fun onVoiceAgain() {

    }

    override fun onStop() {
        super.onStop()
        AudioPlayerManger.stop()
    }

}