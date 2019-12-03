package cn.kc.trainman_apply.dispatchingcommand.fragment.model

import android.util.Log
import cn.kc.integrated_service.CommandApi
import cn.kc.integrated_service.bean.HadDoneBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/9/4
 * 说明：
 */
class HadDoneModel : HadDoneIModel {

    private var mDis: CompositeDisposable = CompositeDisposable()

    override fun getListData(CommState: String, CommType: String, CommContext: String, UId: String, updata: Updata) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(CommandApi::class.java)
                .getCommandPost(CommState, CommType, CommContext, UId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    try {
                        val respone = Constant.gson.fromJson(it, HadDoneBean::class.java)
                        if (respone.state == 1) {
                            val data: ArrayList<HadDoneBean.DataBean> = ArrayList()
                            for (i in 0 until respone.data!!.size) {
                                data!!.add(respone.data!!.get(i))
                            }
                            data?.let { it1 -> updata.setData(it1) }
                        }else{
                            updata.updata("error")
                        }
                    } catch (e: Exception) {
                        Log.e("msg", "出错了+" + e.toString())
                    }
                }, {
                    updata.updata("failed")
                })
        )
    }

    interface Updata {
        fun updata(msg: Any)

        fun setData(data: ArrayList<HadDoneBean.DataBean>)
    }

    fun cleanHttp() {
        mDis.clear()
    }
}

interface HadDoneIModel {

    fun getListData(
        CommState: String, CommType: String, CommContext: String,
        UId: String, updata: HadDoneModel.Updata
    )
}