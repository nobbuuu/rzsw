package com.blackview.base.utils

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Handler
import android.util.Log
import com.blackview.base.common.IMusicActionCallBack
import com.blackview.base.common.IPlayCallBack
import com.blankj.utilcode.util.Utils

object AudioPlayerManger {
    var mediaPlayer: MediaPlayer? = null
    private var mSysManager: AudioManager? = null
    var isPlay: Boolean = false
    var isPause: Boolean = false
    private val mHandler = Handler()
    var musicRes: IntArray = intArrayOf()
    var curMusic: Int = 0
    var curRaw: Int = 0
    private var mActionCallBack: IMusicActionCallBack? = null
    private var iPlayCallBack: IPlayCallBack? = null
    private var globalCallBack: IPlayCallBack? = null
    var currentPositon: Int = 0
    var duration: Int = 0
    var volPosition: Int = 100

    fun initAudioManager(context: Context) {
        mSysManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager //获取媒体系统服务
        val maxVolume = mSysManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        setVolume(maxVolume.toFloat())
        Log.d("aaa", "maxVolume = " + maxVolume)
    }


    fun upSong() {
        curMusic--
        if (curMusic <= 0) {
            curMusic = musicRes.size - 1
        }
        playMusic()
    }

    fun nextSong() {
        curMusic++
        if (curMusic >= musicRes.size) {
            curMusic = 0
            return
        }
        playMusic()
    }

    fun resetMusic(raw: Int) {
        Log.d("aaa", "resetMusic have var")
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        mediaPlayer?.reset()
        this.mediaPlayer = MediaPlayer.create(Utils.getApp(), raw)
        curRaw = raw
        this.currentPositon = 0
        mActionCallBack?.onMusicChange(curMusic)
        mediaPlayer?.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                isPlay = false
                isPause = false
                Log.d("aaa", "action onCompletion manager")
                mActionCallBack?.onCompletion(mediaPlayer)
                iPlayCallBack?.onEnd(curMusic)
                globalCallBack?.onEnd(curMusic)
            }
        })
        mActionCallBack?.onResetMusic()
    }

    fun resetMusic() {
        Log.d("aaa", "resetMusic no var")
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        if (musicRes[curMusic] != curRaw) {
            mediaPlayer?.reset()
            this.mediaPlayer = MediaPlayer.create(Utils.getApp(), musicRes[curMusic])
            curRaw = musicRes[curMusic]
            this.currentPositon = 0
            if (mActionCallBack != null) {
                mActionCallBack!!.onMusicChange(curMusic)
            }
        }
        mediaPlayer?.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                isPlay = false
                isPause = false
                Log.d("aaa", "action onCompletion manager")
                mActionCallBack?.onCompletion(mediaPlayer)
                iPlayCallBack?.onEnd(curMusic)
                globalCallBack?.onEnd(curMusic)
                mHandler.postDelayed(object : Runnable {
                    override fun run() {
                        nextSong()
                    }
                }, 1500)
            }
        })
        mActionCallBack?.onResetMusic()
    }

    fun startMusic() {
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        if (this.mediaPlayer != null) {
            try {
                mediaPlayer?.start()
                iPlayCallBack?.onStart(curMusic)
                globalCallBack?.onStart(curMusic)
                this.duration = mediaPlayer?.duration ?: 1000
                isPlay = true
                isPause = false
                mHandler.post(mRunnable)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun seekToMusic(seekTo: Int) {
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        resetMusic()
        if (this.mediaPlayer != null) {
            mediaPlayer!!.start()
            mediaPlayer!!.seekTo(seekTo)
            mHandler.post(mRunnable)
            isPlay = true
            isPause = false
            mActionCallBack?.onPlayMusic()
        }
    }

    fun pause() {
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        mediaPlayer?.pause()
        isPlay = false
        isPause = true
        mActionCallBack?.onMusicPause()
    }

    fun stop() {
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        mediaPlayer?.stop()
        curRaw = 0
        curMusic = 0
        mHandler.removeCallbacks(mRunnable)
        isPlay = false
        isPause = false
        mActionCallBack?.onMusicStop()
    }

    fun release() {
        if (mediaPlayer == null) {
            initAudioManager(Utils.getApp())
        }
        mediaPlayer?.release()
        isPlay = false
        isPause = false
        mActionCallBack?.onRelease()
    }

    fun playMusic() {
        resetMusic()
        startMusic()
        mActionCallBack?.onPlayMusic()
    }

    fun playRaw(raw: Int, callBack: IPlayCallBack? = null) {
        iPlayCallBack = callBack
        resetMusic(raw)
        startMusic()
        mActionCallBack?.onPlayMusic()
    }

    fun playRaw(rawArray: IntArray, callBack: IPlayCallBack? = null) {
        curMusic = 0
        iPlayCallBack = callBack
        this.musicRes = rawArray
        resetMusic()
        startMusic()
        mActionCallBack?.onPlayMusic()
    }


    fun playMusic(position: Int) {
        curMusic = position
        resetMusic()
        startMusic()
        mActionCallBack?.onPlayMusic()
    }

    fun setVolume(volume: Float) {
        mediaPlayer?.setVolume(volume, volume)
        this.volPosition = (volume * 100).toInt()
        mActionCallBack?.onVolumeChange((volume * 100).toInt())
    }

    private val mRunnable: Runnable = object : Runnable {
        override fun run() {
            if (mediaPlayer != null && isPlay) {
                currentPositon = mediaPlayer!!.getCurrentPosition()
                mActionCallBack?.onPlayProgress(currentPositon)
                mHandler.postDelayed(this, 1000)
            }
        }
    }

    fun setMusicActionCallBack(callBack: IMusicActionCallBack?) {
        mActionCallBack = callBack
    }

    fun setGlobalCallBack(callBack: IPlayCallBack?) {
        globalCallBack = callBack
    }
}