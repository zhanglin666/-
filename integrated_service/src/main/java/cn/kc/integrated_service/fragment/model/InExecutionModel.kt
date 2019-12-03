package cn.kc.trainman_apply.dispatchingcommand.fragment.model

import cn.kc.integrated_service.CommandApi
import cn.kc.integrated_service.bean.InExecutionBeanIng
import cn.kc.integrated_service.bean.ReceiveCommandBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/8/14
 * 说明：
 */
class InExecutionModel {
    private var mDis: CompositeDisposable = CompositeDisposable()

    fun getInExecutionData(
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
                    val valueInfo: InExecutionBeanIng = Constant.gson.fromJson(it, InExecutionBeanIng::class.java)
                    if (valueInfo.state == 1) {
                        val data: ArrayList<InExecutionBeanIng.DataBean> = ArrayList()
                        for (i in 0 until valueInfo.data!!.size) {
                            data!!.add(valueInfo.data!!.get(i))
                        }
                        data?.let { it1 -> updata.setData(it1) }
                    } else {
                        updata.updateView("error")
                    }
                }, {
                    updata.updateView("failed")
                })
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
                })
        )
    }

    interface DataUpdate {
        fun updateView(msg: Any)

        fun setData(data: ArrayList<InExecutionBeanIng.DataBean>)
    }

    fun cleanHTTP() {
        mDis.clear()
    }
}