package cn.kc.trainman_apply.dispatchingcommand.fragment.presenter

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.integrated_service.bean.NoReceiveBean
import cn.kc.trainman_apply.dispatchingcommand.fragment.model.NoReceiveModel
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.NoReceiveIView
import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.util.ToastUtil

/**
 * 作者： Abel .
 * 日期：2019/8/13
 * 说明：
 */
class NoReceivePresenter(private val mView: NoReceiveIView) : NoReceiveIPresenter, NoReceiveModel.DataUpdate {

    private val mModel: NoReceiveModel

    init {
        mModel = NoReceiveModel()
    }

    override fun onCreate() {

    }

    override fun onDestroy() {
        mModel.cleanHTTP()   //取消网络请求
    }

    /**
     * 获取调度分发的命令
     */
    override fun loadData(
        CommState: String, CommType: String, CommContext: String,
        UId: String
    ) {
        mModel.getNoReceiveData(CommState, CommType, CommContext, UId, this)
    }

    /**
     * 接令
     */
    override fun commandReceive(CommIssueId: String, State: String, UId: String, RESOLVE_ID: String) {
        mModel.commandReceive(CommIssueId, State, UId, RESOLVE_ID, this)
    }

    override fun updateView(msg: Any) {
        when (msg) {
            "success" -> {
                mView.commandSuccess()
            }
            "error" -> {
                mView.hideDialog()
                ToastUtil.showToast(BaseApplication.mContext!!, "出错了!")
            }
            "failed" -> {
                mView.hideDialog()
                ToastUtil.showToast(BaseApplication.mContext!!, "连接服务器失败")
            }
            else -> {
                mView.hideDialog()
                Log.e("msg", "else")
            }
        }
    }

    override fun setData(data: ArrayList<NoReceiveBean.DataBean>, commType: String) {
        if (commType.equals("0")) {
            mView.hideDialog()
        }
        mView.showData(data)
    }
}

interface NoReceiveIPresenter : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()

    fun loadData(
        CommState: String, CommType: String, CommContext: String,
        UId: String
    )

    fun commandReceive(
        CommIssueId: String, State: String, UId: String,
        RESOLVE_ID: String
    )
}