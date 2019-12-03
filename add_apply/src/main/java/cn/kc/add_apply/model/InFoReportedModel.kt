package cn.kc.trainman_apply.reported_data.model

import android.util.Log
import cn.kc.add_apply.ReportedDaraApi
import cn.kc.add_apply.bean.EmployeeByIDBean
import cn.kc.add_apply.bean.TimSort
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * 作者： Abel .
 * 日期：2019/9/9
 * 说明：
 */
class InFoReportedModel : InFoReportedIModel {

    private var mDis: CompositeDisposable = CompositeDisposable()

    override fun getResponsibleDepartment(id: String, updata: Updata) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getEmployeeById(id)
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    try {
                        val respone = Constant.gson.fromJson(it, EmployeeByIDBean::class.java)
                        if (respone.state.equals("1")) {
                            updata.success("empID",respone.data!!.get(0))
                        } else {
                            updata.error()
                        }
                    } catch (e: Exception) {
                        Log.e("msg", "出错了+" + e.toString())
                    }
                }, {
                    updata.error()
                })
        )
    }

    override fun getTimSortType(updata: Updata) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getTimSort()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = Constant.gson.fromJson(it, TimSort::class.java)
                    if (info.state.equals("1")) {
                        val data: ArrayList<TimSort.DataBean> = ArrayList()
                        for (i in 0 until info.data!!.size) {
                            data!!.add(info.data!!.get(i))
                        }
                        updata.success("timSort",data)
                    } else {
                        updata.error()
                    }
                }, {
                    updata.error()
                })
        )
    }

    fun clearHTTP() {
        mDis.clear()
    }

    interface Updata {
        fun success(flag: String, msg: Any)
        fun error()
    }
}

interface InFoReportedIModel {
    fun getResponsibleDepartment(id: String, updata: InFoReportedModel.Updata)

    fun getTimSortType(updata: InFoReportedModel.Updata)


}