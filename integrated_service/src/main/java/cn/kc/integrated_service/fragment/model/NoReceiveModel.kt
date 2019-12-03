package cn.kc.trainman_apply.dispatchingcommand.fragment.model

import cn.kc.integrated_service.CommandApi
import cn.kc.integrated_service.bean.NoReceiveBean
import cn.kc.integrated_service.bean.ReceiveCommandBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/8/8
 * 说明：
 */
class NoReceiveModel {
    private var mDis: CompositeDisposable = CompositeDisposable()  //多个网络请求取消
    //    private lateinit var mDis: Disposable    //单个网络请求取消

    fun getNoReceiveData(
        CommState: String, CommType: String, CommContext: String,
        UId: String, updata: DataUpdate
    ) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(CommandApi::class.java)
                .getCommandPost(CommState, CommType, CommContext, UId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val bean: NoReceiveBean = Constant.gson.fromJson(it, NoReceiveBean::class.java)
                    if (bean.state == 1) {
                        val data: ArrayList<NoReceiveBean.DataBean>? = ArrayList()
                        for (i in 0 until bean.data!!.size) {
                            data!!.add(bean.data.get(i))
                        }
                        data?.let { it1 -> updata.setData(it1, CommType) }
                    } else {
                        updata.updateView("error")
                    }
                }, {
                    updata.updateView("failed")
                }
                )
        )
    }

    fun commandReceive(
        CommIssueId: String, State: String, UId: String,
        RESOLVE_ID: String, updata: DataUpdate
    ) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(CommandApi::class.java)
                .getCommandReceive(CommIssueId, State, UId, RESOLVE_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val valueInfo = Constant.gson.fromJson(it, ReceiveCommandBean::class.java)
                    if (valueInfo.state == 1) {
                        updata.updateView("success")
                    } else {
                        updata.updateView("error")
                    }
                }, {
                    updata.updateView("failed")
                }
                )
        )
    }

    interface DataUpdate {
        fun updateView(msg: Any)

        fun setData(data: ArrayList<NoReceiveBean.DataBean>, commType: String)
    }

    fun cleanHTTP(){
        mDis.clear()
    }
}