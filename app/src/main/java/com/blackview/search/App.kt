package com.blackview.search

import com.blackview.base.BaseApplication
import com.blackview.base.utils.AudioPlayerManger
import me.jessyan.autosize.AutoSizeConfig

class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        AudioPlayerManger.initAudioManager(this)
        AutoSizeConfig.getInstance()
            .setBaseOnWidth(false) // ✨ 关键：平板优先以高度为基准
            .setUseDeviceSize(true) // 使用物理尺寸而非逻辑尺寸
            .setExcludeFontScale(true); // 独立处理字体缩放
    }
}