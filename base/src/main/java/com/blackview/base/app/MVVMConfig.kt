package com.blackview.base.app

/**
 * desc   :
 * author : tiaozi
 * date   : 2019-11-17
 */
object MVVMConfig {
    private lateinit var mConfig: GlobalConfig

    fun install(config: GlobalConfig) {
        mConfig = config
    }

    fun getConfig() = mConfig
}