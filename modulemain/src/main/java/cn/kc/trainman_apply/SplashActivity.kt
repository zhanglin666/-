package cn.kc.trainman_apply

import android.os.Bundle
import cn.kc.moduleutils.base.BaseActivity
import cn.kc.trainman_apply.login.view.LoginActivity
import java.util.*

/**
 * 作者： Abel .
 * 日期：2019/12/18
 * 说明：
 */
class SplashActivity : BaseActivity() {
    override fun getLayout() = R.layout.act_splash

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        val task = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    goActivity(this@SplashActivity, LoginActivity().javaClass)
                    finish()
                }
            }
        }
        val timer = Timer()
        timer.schedule(task, 3000)
    }
}