package com.blackview.base.common

import android.media.MediaPlayer

interface IMusicActionCallBack {
    fun onResetMusic()

    fun onPlayMusic()

    fun onVolumeChange(progress: Int)

    fun onMusicPause()

    fun onMusicStop()

    fun onRelease()

    fun onCompletion(mp: MediaPlayer?)

    fun onPlayProgress(progress: Int)

    fun onMusicChange(curMusic: Int)

    fun onAnyAction()
}
