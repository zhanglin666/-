package cn.kc.moduleutils.base

import android.app.Application
import android.content.Context
import cn.kc.moduleutils.util.ScreenAdapter
import cn.kc.moduleutils.util.SharedPreferencesUtils
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 作者：   .
 * 日期： 2019/4/8
 * 版本： V1.0
 * 说明：
 */
open class BaseApplication : Application() {
    var isDebug: Boolean = true

    companion object {
        var mContext: Context? = null
        val preferences by lazy { SharedPreferencesUtils(mContext!!) }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext

        //屏幕适配
        ScreenAdapter.setup(this)
        ScreenAdapter.register(this,720f,
            ScreenAdapter.MATCH_BASE_WIDTH, ScreenAdapter.MATCH_UNIT_DP)

        if (isDebug) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

}