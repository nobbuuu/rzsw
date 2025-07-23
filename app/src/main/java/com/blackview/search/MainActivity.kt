package com.blackview.search

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.blackview.base.kt.ktClick
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import java.util.Locale

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var ttsUseAble: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initTTS()
        findViewById<LinearLayout>(R.id.eyeLay).ktClick {
            if (ttsUseAble){
                tts?.speak("眼睛，eye",TextToSpeech.QUEUE_FLUSH,null,null)
            }
        }
        findViewById<LinearLayout>(R.id.mouthLay).ktClick {
            if (ttsUseAble){
                tts?.speak("嘴巴，mouth",TextToSpeech.QUEUE_FLUSH,null,null)
            }
        }
    }

    private fun initTTS() {
        tts = TextToSpeech(Utils.getApp(), this)
    }
    override fun onInit(status: Int) {
        LogUtils.d(status)
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.CHINA)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                ToastUtils.showShort("该设备不支持TTS功能")
            } else {
                ttsUseAble = true
                tts?.speak("小朋友，一起来了解我们的身体吧！眼睛，eye，嘴巴，mouth",TextToSpeech.QUEUE_FLUSH,null,null)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (ttsUseAble){
            tts?.speak("小朋友，一起来了解我们的身体吧！眼睛，eye，嘴巴，mouth",TextToSpeech.QUEUE_FLUSH,null,null)
        }
    }

}