package cn.kc.trainman_apply.dispatchingcommand.fragment.presenter

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.integrated_service.bean.InExecutionBeanIng
import cn.kc.trainman_apply.dispatchingcommand.fragment.model.InExecutionModel
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.InExecutionIView
import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.util.ToastUtil

/**
 * 作者： Abel .
 * 日期：2019/8/14
 * 说明：
 */
class InExecutionPresenter(private val mView: InExecutionIView) : InExecutionIPresenter, InExecutionModel.DataUpdate {
    override fun onCreate() {

    }

    override fun onDestroy() {
        mModel.cleanHTTP()
    }

    private val mModel: InExecutionModel

    init {
        mModel = InExecutionModel()
    }

    //获取Recycleview列表数据
    override fun loadData(CommState: String, CommType: String, CommContext: String, UId: String) {
        mModel.getInExecutionData(CommState, CommType, CommContext, UId, this)
    }

    //点击执行中完成
    override fun commandReceive(CommIssueId: String, State: String, UId: String, RESOLVE_ID: String) {
        mView.showDialog()
        mModel.commandReceive(CommIssueId,State,UId,RESOLVE_ID,this)
    }

    override fun updateView(msg: Any) {
        when(msg){
            "success" -> {
                mView.showDialog()
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

    override fun setData(data: ArrayList<InExecutionBeanIng.DataBean>) {
        mView.hideDialog()
        mView.showData(data)
    }
}

interface InExecutionIPresenter : LifecycleObserver {
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