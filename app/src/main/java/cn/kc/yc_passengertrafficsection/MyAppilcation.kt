package cn.kc.yc_passengertrafficsection

import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.util.ScreenAdapter


/**
 * 作者： 张承堂  .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
open class MyAppilcation : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        ScreenAdapter.setup(this)
        ScreenAdapter.register(this,360f,
            ScreenAdapter.MATCH_BASE_WIDTH,ScreenAdapter.MATCH_UNIT_DP)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

    }
}