package cn.kc.trainman_apply.reported_data.view

import cn.kc.add_apply.bean.EmployeeByIDBean
import cn.kc.add_apply.bean.TimSort

/**
 * 作者： Abel .
 * 日期：2019/9/10
 * 说明：
 */
interface InfoReportedView {
    fun showDialog()
    fun hideDialog()
    fun getData(msg: EmployeeByIDBean.DataBean)
    fun getTimSortData(msg: ArrayList<TimSort.DataBean>)
}