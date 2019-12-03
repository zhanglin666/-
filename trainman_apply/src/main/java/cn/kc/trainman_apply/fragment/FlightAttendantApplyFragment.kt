package cn.kc.trainman_apply.fragment

import cn.kc.trainman_apply.R
import cn.kc.moduleutils.base.BaseFragment
import cn.kc.moduleutils.util.Logs

/**
 * 作者： Abel .
 * 日期：2019/10/12
 * 说明：乘务应用
 */
class FlightAttendantApplyFragment : BaseFragment() {
    override fun getLayout() = R.layout.fragment_flightattendant_apply

    override fun initData() {
        Logs.e("测试乘务应用页面")
    }
}