package cn.kc.trainman_apply.reported_data.model

import cn.kc.add_apply.ReportedDaraApi
import cn.kc.add_apply.bean.ResponsibleDepartmentBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/9/9
 * 说明：
 */
class ResponsibleDepartmentModel : ResponsibleDepartmentIModel {
    private var mDis: CompositeDisposable = CompositeDisposable()

    override fun getRDData(updateListener: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getDept()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = Constant.gson.fromJson(it, ResponsibleDepartmentBean::class.java)
                    if (info.state.equals("1")) {
                        val data: ArrayList<ResponsibleDepartmentBean.DataBean> = ArrayList()
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

     fun cleanHTTP(){
        mDis.clear()
    }

    interface UpdateView {
        fun success(data: ArrayList<ResponsibleDepartmentBean.DataBean>)
        fun error()
        fun failed()
    }
}

interface ResponsibleDepartmentIModel {
    //获取责任部门列表数据
    fun getRDData(updateListener: ResponsibleDepartmentModel.UpdateView)
}