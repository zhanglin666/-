package cn.kc.trainman_apply.dispatchingcommand.fragment.presenter

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.integrated_service.bean.HadDoneBean
import cn.kc.trainman_apply.dispatchingcommand.fragment.model.HadDoneModel
import cn.kc.trainman_apply.dispatchingcommand.fragment.view.HadDoneView
import cn.kc.moduleutils.base.BaseApplication
import cn.kc.moduleutils.util.ToastUtil

/**
 * 作者： Abel .
 * 日期：2019/9/4
 * 说明：
 */
class HadDonePresenter(private val mView: HadDoneView) : HadDoneIPresenter, HadDoneModel.Updata {

    private val mModel: HadDoneModel

    init {
        mModel = HadDoneModel()
    }

    override fun onCreate() {

    }

    override fun onDestroy() {
        mModel.cleanHttp()
    }

    //获取recycleview列表数据
    override fun loadData(CommState: String, CommType: String, CommContext: String, UId: String) {
        mModel.getListData(CommState, CommType, CommContext, UId, this)
    }

    override fun updata(msg: Any) {
        when (msg) {
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
                Log.e("msg", "else..")
            }
        }

    }

    override fun setData(data: ArrayList<HadDoneBean.DataBean>) {
        mView.hideDialog()
        mView.showData(data)
    }
}

interface HadDoneIPresenter : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()

    fun loadData(
        CommState: String, CommType: String, CommContext: String,
        UId: String
    )
}