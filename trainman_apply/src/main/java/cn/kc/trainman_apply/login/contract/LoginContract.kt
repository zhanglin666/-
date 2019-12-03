package cn.kc.trainman_apply.login.contract

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.trainman_apply.login.model.LoginModel
import cn.kc.moduleutils.base.BaseContract

/**
 * 作者： Abel .
 * 日期：2019/10/10
 * 说明：
 */
interface LoginContract {
    interface Model : BaseContract.Model {
        /**
         * 登录
         */
        fun login(username: String, password: String, callback: LoginModel.UpdateView)
    }

    interface View : BaseContract.View {

    }

    interface Presenter : BaseContract.Presenter , LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate()

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy()

        fun loadData(username: String, password: String)
    }
}