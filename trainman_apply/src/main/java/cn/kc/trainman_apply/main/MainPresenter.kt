package cn.kc.trainman_apply.main

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.trainman_apply.Api
import cn.kc.trainman_apply.NoReceiveBean
import cn.kc.trainman_apply.server.WsListener
import cn.kc.moduleutils.bean.MessageEvent
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import com.neovisionaries.ws.client.WebSocketFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 作者： Abel .
 * 日期：2019/9/6
 * 说明：
 */
class MainPresenter(private val mContext: Context) : MainIPresenter {
    lateinit var wxListener: WsListener
    private lateinit var mDis: Disposable    //单个网络请求取消

    override fun onCreate() {
        Thread(Runnable {
            run {
                wxListener = WsListener(mContext)
                WebSocketFactory().createSocket("ws://192.168.100.86:5623", 10000) //ws地址，和设置超时时间
                    .setMissingCloseFrameAllowed(false)//设置不允许服务端关闭连接却未发送关闭帧
                    .addExtension(Constant.mUID)
                    .addListener(wxListener)//添加回调监听
                    .connectAsynchronously()//异步连接
            }
        }).start()

    }

    override fun onResume() {
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }
        isHaveNoReceive()
    }

    /**
     * 判断是否有未接令的消息
     */
    fun isHaveNoReceive() {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis = RetrofitUtils.instance!!.getApiServier(Api::class.java)
            .getCommandPost(
                "1", "0", "",
                Constant.mUID
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val bean: NoReceiveBean = Constant.gson.fromJson(it, NoReceiveBean::class.java)
                if (bean.state == 1) {
                    if (bean.data.size > 0) {
                        wxListener.videoPlay()
                    }
                }
            }
            )
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun Event(messageEvent: MessageEvent) {
        if (messageEvent.getMessage().equals("stopVideo")) {
            wxListener.exitThread()
        }
    }

    override fun onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

}


interface MainIPresenter : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()

}