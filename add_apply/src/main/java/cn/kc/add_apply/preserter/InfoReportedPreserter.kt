package cn.kc.trainman_apply.reported_data.preserter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import cn.kc.add_apply.bean.EmployeeByIDBean
import cn.kc.add_apply.bean.TimSort
import cn.kc.trainman_apply.reported_data.model.InFoReportedModel
import cn.kc.trainman_apply.reported_data.view.InfoReportedView

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
class InfoReportedPreserter(private val mView: InfoReportedView) :
    InfoReportedIPreserter, InFoReportedModel.Updata {

    var empIDFlag = false
    var timSortFlag = false
    private val mModel: InFoReportedModel

    init {
        mModel = InFoReportedModel()
    }

    override fun onCreate() {
        mView.showDialog()
    }

    override fun onStart() {

    }

    override fun onDestroy() {
        mModel.clearHTTP()
    }

    //根据社保号获取用户信息
    override fun getEmployeeByID(id: String) {
        mModel.getResponsibleDepartment(id, this)
    }

    //获取添乘类别
    override fun getTimSortType() {
        mModel.getTimSortType(this)
    }

    override fun success(flag: String, msg: Any) {
        if (flag.equals("empID")) {
            empIDFlag = true
            mView.getData(msg as EmployeeByIDBean.DataBean)
        }
        if (flag.equals("timSort")) {
            timSortFlag = true
            mView.getTimSortData(msg as ArrayList<TimSort.DataBean>)
        }
        if (timSortFlag && empIDFlag) {
            mView.hideDialog()
        }
    }

    override fun error() {
        mView.hideDialog()
    }
}

interface InfoReportedIPreserter : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy()

    /**
     * 根据社保号获取用户信息
     */
    fun getEmployeeByID(id: String)

    fun getTimSortType()

}