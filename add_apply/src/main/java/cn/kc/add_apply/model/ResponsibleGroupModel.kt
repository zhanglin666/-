package cn.kc.trainman_apply.reported_data.model

import cn.kc.add_apply.ReportedDaraApi
import cn.kc.add_apply.bean.GroupBean
import cn.kc.moduleutils.http.Constant
import cn.kc.moduleutils.http.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class ResponsibleGroupModel : ResponsibleGroupIModel {
    private var mDis: CompositeDisposable = CompositeDisposable()

    override fun getGroupData(deptId: String, updateListener: UpdateView) {
        RetrofitUtils.setBaseUrl(Constant.mHOST)
        mDis.add(
            RetrofitUtils.instance!!.getApiServier(ReportedDaraApi::class.java)
                .getTeamByDepID(deptId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = Constant.gson.fromJson(it, GroupBean::class.java)
                    if (info.state.equals("1")) {
                        val data: ArrayList<GroupBean.DataBean> = ArrayList()
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

    fun cleanHttp() {
        mDis.clear()
    }

    interface UpdateView {
        fun success(data: ArrayList<GroupBean.DataBean>)
        fun error()
        fun failed()
    }
}

interface ResponsibleGroupIModel {
    //获取责任班组列表数据
    fun getGroupData(id: String, updateListener: ResponsibleGroupModel.UpdateView)
}