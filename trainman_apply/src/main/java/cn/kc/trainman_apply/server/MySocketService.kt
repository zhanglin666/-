package cn.kc.trainman_apply.server

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import cn.kc.moduleutils.bean.MessageEvent
import cn.kc.moduleutils.http.Constant
import com.neovisionaries.ws.client.WebSocketFactory
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 作者： Abel .
 * 日期：2019/9/5
 * 说明：
 */
class MySocketService : Service() {

    lateinit var wxListener: WsListener
    private val binder = MyBinder()

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    inner class MyBinder : Binder() {
        internal val service: MySocketService
            get() = this@MySocketService
    }

    override fun onCreate() {
        super.onCreate()
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }
    }

    fun excute() {
        wxListener = WsListener(this)
        WebSocketFactory().createSocket("ws://192.168.100.86:5623", 10000) //ws地址，和设置超时时间
            .setMissingCloseFrameAllowed(false)//设置不允许服务端关闭连接却未发送关闭帧
            .addExtension(Constant.mUID)
//            .addExtension("222")
            .addListener(wxListener)//添加回调监听
            .connectAsynchronously()//异步连接
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun Event(messageEvent: MessageEvent) {
        if (messageEvent.getMessage().equals("stopVideo")) {
            wxListener.exitThread()
        }
    }

    override fun onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }
}