package cn.kc.trainman_apply.reported_data.model

import cn.kc.add_apply.ReportedDaraApi
import cn.kc.add_apply.bean.TrainAddressBean
import cn.kc.add_apply.bean.TrainAllBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class TrainAllModel {
    private var mDis: CompositeDisposable = CompositeDisposable()

    fun getTrainAll(deptName: String, groupName: String, updateListener: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getTrainAll(deptName, groupName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = Constant.gson.fromJson(it, TrainAllBean::class.java)
                    if (info.state.equals("1")) {
                        val data: ArrayList<TrainAllBean.DataBean> = ArrayList()
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
        )
    }

    fun getStation(deptName: String, updateListener: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getStation(deptName)
                .delay(1,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = Constant.gson.fromJson(it, TrainAddressBean::class.java)
                    if (info.state.equals("1")) {
                        val data: ArrayList<String> = ArrayList()
                        for (i in 0 until info.data!!.size) {
                            data!!.add(info.data?.get(i)?.statioN_NAME.toString())
                        }
                        updateListener.success(data)
                    } else {
                        updateListener.error()
                    }
                }, {
                    updateListener.error()
                })
        )
    }


    fun cleanHttp() {
        mDis.clear()//取消订阅
    }

    interface UpdateView {
        fun success(data: Any)
        fun error()
        fun failed()
    }
}