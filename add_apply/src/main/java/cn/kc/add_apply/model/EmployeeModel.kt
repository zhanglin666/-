package cn.kc.trainman_apply.reported_data.model

import cn.kc.add_apply.ReportedDaraApi
import cn.kc.add_apply.bean.EmployeeBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class EmployeeModel {

    private lateinit var mDis: Disposable    //单个网络请求取消

    fun getEmployee(deptName:String,groupName:String,updateListener: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis = RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
            .getEmployee(deptName,groupName,"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val info = Constant.gson.fromJson(it, EmployeeBean::class.java)
                if (info.state.equals("1")) {
                    val data: ArrayList<EmployeeBean.DataBean> = ArrayList()
                    for (i in 0 until info.data!!.size) {
                        data!!.add(info.data!!.get(i))
                    }
                    updateListener.success(data)
                } else {
                    updateListener.error()
                }
            }, {
                updateListener.failed()
            })
    }

    fun cleanHttp() {
        if (!mDis.isDisposed) {
            mDis.dispose()//取消订阅
        }
    }

    interface UpdateView {
        fun success(data: ArrayList<EmployeeBean.DataBean>)
        fun error()
        fun failed()
    }
}